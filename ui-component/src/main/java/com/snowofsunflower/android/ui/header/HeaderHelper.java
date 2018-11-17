package com.snowofsunflower.android.ui.header;

import android.support.annotation.StringRes;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snowofsunflower.ui_component.R;

/**
 * Created by zhouztashin on 2018/11/16.
 */

public class HeaderHelper {

    private View mView;

    public HeaderHelper(View rootHeaderView) {
        this(rootHeaderView, new DefaultHeaderView(rootHeaderView.getContext()));
    }

    public HeaderHelper(View rootHeaderView, IHeaderView headerView) {
        mView = rootHeaderView;
        LinearLayout llLeft = mView.findViewById(R.id.ll_left);
        LinearLayout llRight = mView.findViewById(R.id.ll_right);
        llLeft.addView(headerView.getLeftView());
        llRight.addView(headerView.getRightView());
    }

    public static int getLayoutId() {
        return R.layout.component_header_bar;
    }

    public void setTitle(String str) {
        TextView tv = mView.findViewById(R.id.tv_title);
        tv.setText(str);
    }

    public void setTitle(@StringRes int id) {
        TextView tv = mView.findViewById(R.id.tv_title);
        tv.setText(id);
    }

    public void setLeftClickListener(View.OnClickListener l) {
        mView.findViewById(R.id.ll_left).setOnClickListener(l);
    }

    public void setRightClickListener(View.OnClickListener l) {
        mView.findViewById(R.id.ll_right).setOnClickListener(l);
    }

    public View getLeftView() {
        return mView.findViewById(R.id.ll_left);
    }

    public View getRightView() {
        return mView.findViewById(R.id.ll_right);
    }
}
