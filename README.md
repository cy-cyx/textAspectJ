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

### within 和 whitincode

#### whitin 指定某个类 配合execution 使用

```
@Pointcut("execution(* android.com.aspectj.BaseActivity+.onCreate(..)) && within(android.com.aspectj.MainActivity)")
```

在所有继承BaseActivity中指定MainActivity，如果想排除即用 !(备注：可能该库仅支持&& 不支持||)

```
@Pointcut("execution(* android.com.aspectj.BaseActivity+.onCreate(..)) && !within(android.com.aspectj.MainActivity)")
```

#### whitincode 指定某个方法不插入 配合call 使用

```
@Pointcut("call(* android.com.aspectj.TextAspectjCall.call()) && withincode(* android.com.aspectj.MainActivity.onCreate(..))")
```

