package com.snowofsunflower.android.ui.activity;

/**
 * Created by zhouztashin on 2018/11/13.
 */

public interface UI {


    /**
     * 获取布局文件ID
     *
     * @return
     */
    int getContentLayoutId();

    /**
     * 初始化控件与事件
     */
    void initViewAndEvent();
}
