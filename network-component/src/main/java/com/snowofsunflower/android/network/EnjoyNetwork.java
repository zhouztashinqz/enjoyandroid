package com.snowofsunflower.android.network;

import com.snowofsunflower.android.network.http.builder.RetrofitBuilder;
import com.snowofsunflower.android.network.http.builder.RetrofitJunitBuilder;

import java.util.List;

import okhttp3.Interceptor;

/**
 * Refactor by Zhouztashin on 2018/4/16
 * Http服务类工厂
 */

public class EnjoyNetwork {

    private static RetrofitBuilder sBaseRetrofitBuilder = new RetrofitBuilder();
    private static RetrofitJunitBuilder sJunitRetrofitBuilder = new RetrofitJunitBuilder();

    /**
     * 生成网络访问服务类。
     *
     * @param serviceInterface
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T createHttpService(Class<T> serviceInterface, String url) {
        return sBaseRetrofitBuilder.createServiceFrom(serviceInterface, url);
    }

    /***
     * 生成用于单元测试的网络访问服务类。
     * @param serviceInterface
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T createHttpServiceForJunit(Class<T> serviceInterface, String url) {
        return sJunitRetrofitBuilder.createServiceFromForJUnit(serviceInterface, url);
    }

    /**
     * 设置拦截器
     *
     * @param list
     */
    public static void addHttpServiceInteceptor(List<Interceptor> list) {
        sBaseRetrofitBuilder.setInterceptor(list);
    }

}
