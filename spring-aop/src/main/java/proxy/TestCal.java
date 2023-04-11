package proxy;

/**
 * output:
 * 调用前输出。。。。。。。
 * 结果为：3
 * 调用后输出。。。。。。。
 * 调用前输出。。。。。。。
 * 结果为：100
 * 调用后输出。。。。。。。
 *
 * 通过动态代理可以讲CalculatorImp中的所有方法都加入前后的打印，不需要再去每个方法中写大量的重复代码（静态代理）
 */
public class TestCal {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImp());
        //获取代理对象
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        //代理对象调用方法
        proxy.add(1,2);
        proxy.mul(10,10);
    }
}
