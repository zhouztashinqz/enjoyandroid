package com.snowofsunflower.android.network.http.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhouztashin on 2018/4/17.
 * RetrofitService生成器
 */

public class RetrofitBuilder {

    private List<Interceptor> mInterceptor;

    public RetrofitBuilder(List<Interceptor> interceptors) {
        this.mInterceptor = interceptors;
    }

    public RetrofitBuilder(Interceptor interceptors) {
        mInterceptor = new ArrayList<>();
        mInterceptor.add(interceptors);
    }

    public RetrofitBuilder() {

    }


    public void setInterceptor(List<Interceptor> interceptors) {
        this.mInterceptor = interceptors;
    }

    public <T> T createServiceFrom(Class<T> serviceClass, String endpoint) {
        Retrofit retrofit = getRetrofitBuilder(endpoint).build();
        return retrofit.create(serviceClass);
    }


    private Retrofit.Builder getRetrofitBuilder(String endpoint) {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogClient());
    }

    private OkHttpClient getLogClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(45, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
        if (mInterceptor != null) {
            for (Interceptor interceptor : mInterceptor
                    ) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }
}
