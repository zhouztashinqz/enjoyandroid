package com.snowofsunflower.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by zhouztashin on 2018/11/13.
 */

public abstract class BaseActivity extends AppCompatActivity implements UI {

    protected final String TAG = getClass().getSimpleName();
    protected BaseActivity self = null;
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        self = this;
        setLayout(getContentLayoutId());
        if (isTint()) {
            initTint();
        }
    }

    private void initTint() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFullScreen()) {
            if (hasFocus) {
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            ImmersionBar.with(this).destroy();
        }
    }


    /**
     * full screen mode
     *
     * @return
     */
    public boolean isFullScreen() {
        return false;
    }


    /**
     * need immersion bar
     */
    public boolean isTint() {
        return true;
    }

    /**
     * init layout and set view
     *
     * @param layoutId
     */
    protected void setLayout(@LayoutRes int layoutId) {
        if (layoutId != 0) {
            setContentView(layoutId);
            initViewAndEvent();
        }
    }


}
