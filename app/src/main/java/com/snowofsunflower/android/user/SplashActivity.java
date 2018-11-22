package com.snowofsunflower.android.user;

import com.snowofsunflower.android.ui.activity.BaseActivity;
import com.snowofsunflower.app.R;

/**
 * Created by zhouztashin on 2018/11/22.
 */

public class SplashActivity extends BaseActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.act_splash;
    }

    @Override
    public void initViewAndEvent() {

    }

    @Override
    public boolean isFullScreen() {
        return true;
    }
}
