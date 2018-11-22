package com.snowofsunflower.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.snowofsunflower.android.ui.activity.BarActivity;
import com.snowofsunflower.android.ui.header.HeaderHelper;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zhouztashin on 2018/11/13.
 */

public abstract class EnjoyActivity extends BarActivity {

    private HeaderHelper mHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        mHeader = new HeaderHelper(getBarView());
        ImmersionBar.with(this)
                .statusBarView(mHeader.getImmersionView())
                .init();
    }


    public HeaderHelper header() {
        return mHeader;
    }

    @Override
    final protected int getBarLayoutId() {
        return HeaderHelper.getLayoutId();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    public boolean useEventBus() {
        return false;
    }

}
