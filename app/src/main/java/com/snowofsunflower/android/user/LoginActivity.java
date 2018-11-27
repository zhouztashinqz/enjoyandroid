package com.snowofsunflower.android.user;

import com.gyf.barlibrary.ImmersionBar;
import com.snowofsunflower.android.ui.activity.BaseActivity;
import com.snowofsunflower.app.R;

/**
 * Created by zhouztashin on 2018/11/22.
 */

public class LoginActivity extends BaseActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initViewAndEvent() {
        darkTitle();
    }


    public void darkTitle(){
        mImmersionBar.statusBarDarkFont(true, 0.2f) .init();
    }
}
