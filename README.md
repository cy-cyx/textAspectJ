### 通配符：

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

### call和execution

#### call

是在调用处插入代码

```
public class Activity1 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在这里插入
        new TextAspectjCall().call();
    }
}
```

#### execution

在对应的方法处插入方法

```
public class TextAspectjCall {

    public void call() {
        // 在这里插入
    }
}
```