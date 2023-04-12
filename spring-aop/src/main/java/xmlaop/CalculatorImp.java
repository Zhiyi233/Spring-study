package xmlaop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImp implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i+j;
        System.out.println("结果为："+result);
        //int a = 1/0;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i*j;
        System.out.println("结果为："+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i-j;
        System.out.println("结果为："+result);
        return result;
    }
}
