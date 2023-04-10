package com.atguigu.bean;

import com.atguigu.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    }

    public void loadBean(File file) throws Exception {
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

                        Class<?> clazz = Class.forName(allName);

                        //判断是否为接口
                        if(!clazz.isInterface()){
                            //判断是否为注解bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
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
}
