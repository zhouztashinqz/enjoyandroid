package com.snowofsunflower.android.network.http.protocol;

import java.util.List;

/**
 * Created by zhouztashin on 2018/11/2.
 */

public class ResultListWrapper<T> extends Result {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
