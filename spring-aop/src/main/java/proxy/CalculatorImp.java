package proxy;

public class CalculatorImp implements Calculator{
    @Override
    public void add(int i, int j) {
        int result = i+j;
        System.out.println("结果为："+result);
    }

    @Override
    public void mul(int i, int j) {
        int result = i*j;
        System.out.println("结果为："+result);
    }
}
