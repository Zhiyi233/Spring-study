package com.atguigu.bean;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 手动实现AnnotationApplicationContext基于反射机制和注解
 */
public class AnnotationApplicationContext implements ApplicationContext{

    //map 放bean的实例对象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置扫描规则
    public AnnotationApplicationContext(String basePackage){
        String packagePath = basePackage.replaceAll("\\.", "\\\\");

        //获取绝对路径
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                //字符串截取，获取包前面的路径
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                //包扫描
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //属性的注入
        loadDi();

    }

    private void loadBean(File file) throws Exception {
        if(file.isDirectory()){
            File[] childrenFiles = file.listFiles();

            if(childrenFiles==null || childrenFiles.length==0){
                return;
            }

            //文件夹不为空遍历所有内容
            for(File child:childrenFiles){
                if(child.isDirectory()){
                    //递归
                    loadBean(child);
                }else{
                    //是文件的话，得到包路径+类名称部分-字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);

                    if(pathWithClass.contains(".class")){
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        //反射获取对象clazz
                        Class<?> clazz = Class.forName(allName);

                        //判断是否为接口
                        if(!clazz.isInterface()){
                            //判断是否为注解bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                //newInstance()来加载类
                                Object instance = clazz.getConstructor().newInstance();

                                if(clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else{
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void loadDi(){
        //1 实例化的对象都是在beanFactory集合中
        //1 遍历map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for(Map.Entry<Class, Object> entry:entries){
            //2 获取map集合的每个对象（value），每个对象属性获取到
            Object obj = entry.getValue();

            //获取对象Class
            Class<?> clazz = obj.getClass();

            //对象属性获取到
            Field[] declaredFields = clazz.getDeclaredFields();

            //3 遍历得到的每个对象的属性的数组，得到每个属性
            for(Field filed:declaredFields){
                //4 判断属性上面是否有@Di注解，和上面@bean一样
                Di annotation = filed.getAnnotation(Di.class);
                if(annotation!=null){
                    //如果是私有属性，设置可以设置值
                    filed.setAccessible(true);

                    //5 如果有@Di注解，就把对象注入
                    try {
                        //根据得到的属性的类型，找到对象注入
                        filed.set(obj,beanFactory.get(filed.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
