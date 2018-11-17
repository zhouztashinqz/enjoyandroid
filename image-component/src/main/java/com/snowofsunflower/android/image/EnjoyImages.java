package com.snowofsunflower.android.image;

import android.content.Context;

import com.snowofsunflower.image_component.R;

/**
 * Created by zhouztashin on 2018/10/31.
 */

public class EnjoyImages {

    private static DefaultImageRound sDefaultImageRound;
    private static ImageCircle sImageCircle;

    public static IImageLoader getPureLoader(Context c) {
        return new GlideImageLoader().with(c);
    }

    /**
     * 默认添加了错误图片与加载图片
     *
     * @param c
     * @return
     */
    public static IImageLoader getLoader(Context c) {
        return new GlideImageLoader().with(c).placeholder(R.drawable.com_image_load_placeholder).error(R.drawable.com_image_load_error);
    }

    public static IImageLoader getRoundLoader(Context c) {
        if (sDefaultImageRound == null) {
            sDefaultImageRound = new DefaultImageRound(c);
        }
        return new GlideImageLoader().with(c).placeholder(R.drawable.com_image_load_placeholder).
                shape(sDefaultImageRound).
                error(R.drawable.com_image_load_error);
    }

    public static IImageLoader getCircleLoader(Context c) {
        if (sImageCircle == null) {
            sImageCircle = new ImageCircle();
        }
        return new GlideImageLoader().with(c).placeholder(R.drawable.com_image_load_placeholder).
                shape(sImageCircle).
                error(R.drawable.com_image_load_error);
    }

}
