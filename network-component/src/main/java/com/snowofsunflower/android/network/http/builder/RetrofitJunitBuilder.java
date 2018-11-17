package com.snowofsunflower.android.network.http.builder;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhouztashin on 2018/4/17.
 * RetrofitService生成器
 */

public class RetrofitJunitBuilder {

    private List<Interceptor> mInterceptor;

    public RetrofitJunitBuilder(List<Interceptor> interceptors) {
        this.mInterceptor = interceptors;
    }

    public RetrofitJunitBuilder(Interceptor interceptors) {
        mInterceptor = new ArrayList<>();
        mInterceptor.add(interceptors);
    }

    public RetrofitJunitBuilder() {

    }


    public void setInterceptor(List<Interceptor> interceptors) {
        this.mInterceptor = interceptors;
    }


    /**
     * 创建用于Junit的Retrofit服务。
     *
     * @param serviceClass
     * @param endpoint
     * @param <T>
     * @return
     */
    public <T> T createServiceFromForJUnit(Class<T> serviceClass, String endpoint) {
        Retrofit retrofit = getJUnitRetrofitBuilder(endpoint).build();
        return retrofit.create(serviceClass);
    }

    private Retrofit.Builder getJUnitRetrofitBuilder(String endpoint) {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getJUnitClient());
    }

    private OkHttpClient getJUnitClient() {
        ExecutorService executorService = new ExecutorService() {
            @Override
            public void shutdown() {

            }

            @NonNull
            @Override
            public List<Runnable> shutdownNow() {
                return null;
            }

            @Override
            public boolean isShutdown() {
                return false;
            }

            @Override
            public boolean isTerminated() {
                return false;
            }

            @Override
            public boolean awaitTermination(long timeout, @NonNull TimeUnit unit) throws InterruptedException {
                return false;
            }

            @NonNull
            @Override
            public <T> Future<T> submit(@NonNull Callable<T> task) {
                return null;
            }

            @NonNull
            @Override
            public <T> Future<T> submit(@NonNull Runnable task, T result) {
                return null;
            }

            @NonNull
            @Override
            public Future<?> submit(@NonNull Runnable task) {
                return null;
            }

            @NonNull
            @Override
            public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> tasks) throws InterruptedException {
                return null;
            }

            @NonNull
            @Override
            public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> tasks, long timeout, @NonNull TimeUnit unit) throws InterruptedException {
                return null;
            }

            @NonNull
            @Override
            public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> tasks, long timeout, @NonNull TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public void execute(@NonNull Runnable command) {
                command.run();
            }
        };
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(45, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .dispatcher(new Dispatcher(executorService));
        if (mInterceptor != null) {
            for (Interceptor interceptor : mInterceptor
                    ) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();

    }

}
