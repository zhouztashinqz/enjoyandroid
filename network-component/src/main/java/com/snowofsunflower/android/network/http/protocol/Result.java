package com.snowofsunflower.android.network.http.protocol;

/**
 * Created by zhouztashin on 2018/11/2.
 */

public class Result {
    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        if (status == 100) {
            return true;
        } else {
            return false;
        }
    }
}
