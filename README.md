通配符：

* 代表任意数量的字符

.. 代表包结构下，任意子包数量；参数下，任意参数

+ 继承关系

例子：
```
    // MainActivity(继承BaseActivity)

    @Pointcut("execution(* android.com.aspectj.MainActivity.onCreate(..))")
    //    @Pointcut("execution(* *..MainActivity.onCreate(..))")
    //    @Pointcut("execution(* *.*.*.MainActivity.onCreate(..))")
    //    @Pointcut("execution(* android.com.aspectj.BaseActivity+.onCreate(..))")
    public void activityOnCreatePointcut() {

    }
```