package android.com.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspectj {


    //    @Pointcut("execution(* android.com.aspectj.MainActivity.onCreate(..))")
    //    @Pointcut("execution(* *..MainActivity.onCreate(..))")
    //    @Pointcut("execution(* *.*.*.MainActivity.onCreate(..))")
    @Pointcut("execution(* android.com.aspectj.BaseActivity+.onCreate(..))")
    public void activityOnCreatePointcut() {

    }

    @Before("activityOnCreatePointcut()")
    public void activityOnCreateBefore(JoinPoint joinPoint) {
        Log.d("xx", "activityOnCreateBefore: " + joinPoint.getThis());
    }

    @Around("activityOnCreatePointcut()")
    public void activityOnCreateAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d("xx", "activityOnCreateAround: " + joinPoint.getThis());
        joinPoint.proceed();
    }

    // 如果After和Around同时存在,After必须在Around之后
    @After("activityOnCreatePointcut()")
    public void activityOnCreateAfter(JoinPoint joinPoint) {
        Log.d("xx", "activityOnCreateAfter: " + joinPoint.getThis());
    }
}
