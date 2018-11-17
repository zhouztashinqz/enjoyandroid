package com.snowofsunflower.android.ui.header;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.snowofsunflower.ui_component.R;

/**
 * Created by zhouztashin on 2018/11/16.
 */

public class DefaultHeaderView implements IHeaderView {

    private Context mContext;
    private ImageView ivLeft;
    private ImageView ivRight;

    public DefaultHeaderView(Context context) {
        mContext = context;
    }

    @Override
    public View getLeftView() {
        ivLeft = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.component_header_imageview, null);
        ivLeft.setImageResource(R.drawable.component_header_back);
        return ivLeft;
    }

    @Override
    public View getRightView() {
        ivRight = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.component_header_imageview, null);
        ivRight.setVisibility(View.GONE);
        return ivRight;
    }

    public void setRightImageResource(@DrawableRes int res) {
        ivRight.setImageResource(res);
    }
}
