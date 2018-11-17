package com.snowofsunflower.android.network.http;

/**
 * Created by zhouztashin on 2018/11/2.
 */

public enum ErrorCode {


    PROTOCOL_ERROR(-120),    //协议解析错误
    JAVA_EXCEPTION(-130),    //Java异常错误
    HTTP_RESPONSE_ERROR(-140),   //网络响应错误
    NETWORK_ERROR(-150);    //网络访问异常

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


}
