package anoAop;

//切面类

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //切面类
@Component //ioc容器
public class LogAspect {

    //设置切入点，通知类型
    //切入点表达式: execution(访问修饰符 方法返回类型 方法所在类的全类名.方法名 参数类型或..表示任意参数)
    // *()表示任意方法
    //通知类型:
    // 前置通知 @Before(value="切入点表达式配置切入点")
    @Before(value = "execution(public int anoAop.CalculatorImp.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->前置通知，方法名："+name+",参数："+ Arrays.toString(args));//+methodName+",参数："+args);
    }
    // 后置通知 @After()
    @After(value = "execution(* anoAop.CalculatorImp.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger--->后置通知，方法名："+name+",参数："+ Arrays.toString(args));
    }

    // 返回通知 @AfterReturning()
    @AfterReturning(value = "execution(public int anoAop.CalculatorImp.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger--->返回通知，方法名："+name+" 目标方法的返回结果："+result);

    }

    // 异常通知 @AfterThrowing()
    @AfterThrowing(value = "execution(* anoAop.CalculatorImp.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger--->异常通知，方法名："+name+"目标方法的返回结果："+ex);
    }
    // 环绕通知 @Around()
    @Around(value = "execution(* anoAop.CalculatorImp.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
//        System.out.println("Logger--->异常通知，方法名："+name+" 参数："+Arrays.toString(args));
        try{
            System.out.println("环绕通知===目标方法之前执行");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知===目标方法返回值之后");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知===目标方法出现异常执行");

        }finally {
            System.out.println("环绕通知===目标方法执行完毕");
        }
        return result;
    }
}
