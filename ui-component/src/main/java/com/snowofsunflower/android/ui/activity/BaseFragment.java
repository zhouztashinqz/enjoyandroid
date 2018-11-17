package com.snowofsunflower.android.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhouztashin on 2018/11/13.
 */

public abstract class BaseFragment extends Fragment implements UI {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentLayoutId() != 0) {
            mView = inflater.inflate(getContentLayoutId(), container, false);
            initViewAndEvent();
        }
        return mView;
    }

}
