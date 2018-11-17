package com.snowofsunflower.android.network.http.protocol;

/**
 * Created by zhouztashin on 2018/11/2.
 */

public class ResultWrapper<T> extends Result {

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }


}
