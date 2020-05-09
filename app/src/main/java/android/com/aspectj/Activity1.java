package android.com.aspectj;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * create by caiyx in 2020/5/9
 */
public class Activity1 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new TextAspectjCall().call();
    }
}
