package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy(){
        /**
         * Proxy.newProxyInstance() 有三个参数：
         * 1.ClassLoader loader 类加载器 加载动态生成代理类的加载器
         * 2.interfaces: 目标对象实现的所有接口的Class类型数组
         * 3.InvocationHandler: 设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler(){
            @Override
            /*
                代理对象
                需要重写目标对象的方法
                对应method中的参数
             */
            public Object invoke(Object proxy,
                                 Method method,
                                 Object[] args) throws Throwable {
                //方法调用之前
                System.out.println("调用前输出。。。。。。。");
                //调用目标方法
                Object result = method.invoke(target, args);

                //方法调用之后
                System.out.println("调用后输出。。。。。。。");
                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
