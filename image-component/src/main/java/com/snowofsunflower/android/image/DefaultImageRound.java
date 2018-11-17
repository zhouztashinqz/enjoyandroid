package com.snowofsunflower.android.image;

import android.content.Context;

import com.snowofsunflower.image_component.R;

/**
 * Created by zhouztashin on 2018/10/31.
 * 默认的圆角图片
 */

public class DefaultImageRound extends ImageRound {
    public DefaultImageRound(Context context) {
        super((int) context.getResources().getDimension(R.dimen.round));
    }
}
