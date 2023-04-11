package anoAop;

//切面类

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //切面类
@Component //ioc容器
public class LogAspect {

    //设置切入点，通知类型
    //切入点表达式: execution(访问修饰符 方法返回类型 方法所在类的全类名.方法名 参数类型或..表示任意参数)
    // *()表示任意方法
    //通知类型:
    // 前置通知 @Before(value="切入点表达式配置切入点")
    @Before(value = "execution(public int anoAop.CalculatorImp.*(..))")
    public void beforeMethod(){

        System.out.println("Logger--->前置通知，方法么：");//+methodName+",参数："+args);
    }
    // 返回通知 @AfterReturning()
    // 异常通知 @AfterThrowing()
    // 后置通知 @After()
    // 环绕通知 @Around()

}
