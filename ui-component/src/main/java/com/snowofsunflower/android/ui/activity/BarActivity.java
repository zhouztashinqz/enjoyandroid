package com.snowofsunflower.android.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.snowofsunflower.ui_component.R;


/**
 * Created by zhouztashin on 2018/11/13.
 */

public abstract class BarActivity extends BaseActivity {


    private void setRootView() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        LayoutInflater.from(self).inflate(R.layout.component_activity_bar, viewGroup, true);
    }

    private void setBarAndContentView() {
        FrameLayout flBar = findViewById(R.id.fl_bar);
        FrameLayout flContent = findViewById(R.id.fl_bar);
        LayoutInflater.from(self).inflate(getBarLayoutId(), flBar);
        if (getContentLayoutId() != 0) {
            LayoutInflater.from(self).inflate(getContentLayoutId(), flContent);
            initViewAndEvent();
        }
    }

    @Override
    final protected void setLayout(int layoutId) {
        if (getBarLayoutId() != 0) {
            setRootView();
            setBarAndContentView();
        } else {
            super.setLayout(getContentLayoutId());
        }
    }

    public View getBarView() {
        return findViewById(R.id.fl_bar);
    }

    protected abstract int getBarLayoutId();

    public void hideBar() {
        if (getBarView() != null) {
            getBarView().setVisibility(View.GONE);
        }
    }

    public void showBar() {
        if (getBarView() != null) {
            getBarView().setVisibility(View.VISIBLE);
        }
    }

}
