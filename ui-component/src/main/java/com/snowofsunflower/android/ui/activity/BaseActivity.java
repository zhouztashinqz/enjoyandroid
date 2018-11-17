package com.snowofsunflower.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhouztashin on 2018/11/13.
 */

abstract class BaseActivity extends AppCompatActivity implements UI {

    protected final String TAG = getClass().getSimpleName();
    protected BaseActivity self = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        self = this;
        setLayout(getContentLayoutId());
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
