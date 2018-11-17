package com.snowofsunflower.android.network.http;

/**
 * Created by zhouztashin on 2018/11/2.
 */

public interface ErrorMessage {
    public static String SERVICE_BUSY = "服务器繁忙";
    public static String PROTOCOL_ERROR = "协议解析错误";
    public static String HTTP_ERROR = "网络访问异常";
    public static final String CONNECT_ERROR = "网络访问失败，请检查网络";
    public static final String UNKNOWN_HOST = "网络访问失败,连接不到主机";
    public static final String SOCKET_ERROR = "网络访问失败,无法建立连接";
    public static final String CONNECT_TIMEOUT = "连接超时";

}
