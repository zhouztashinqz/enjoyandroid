package com.snowofsunflower.android.network.http.callback;

import android.support.annotation.NonNull;

import com.google.gson.JsonSyntaxException;
import com.snowofsunflower.android.network.http.ErrorCode;
import com.snowofsunflower.android.network.http.ErrorMessage;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhouztashin on 2018/11/2.
 */

public abstract class ResultCallback<T> implements Callback<T> {

    private static final String TAG = "ResultCallback";

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

        try {
            if (response.code() == 200) {
                T result = response.body();
                if (result != null) {
                    success(result, response);
                } else {
                    String errorMsg = ErrorMessage.PROTOCOL_ERROR;
                    if (response.errorBody() != null) {
                        errorMsg = response.errorBody().string();
                    }
                    failure(ErrorCode.PROTOCOL_ERROR, errorMsg);
                }
            } else {
                String errorMsg = ErrorMessage.HTTP_ERROR;
                failure(ErrorCode.HTTP_RESPONSE_ERROR, errorMsg.concat(",响应码:" + response.code()));
            }
        } catch (Exception e) {
            failure(ErrorCode.JAVA_EXCEPTION, e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        t.printStackTrace();
        if (!call.isCanceled()) {
            String failureMsg = t.getMessage();
            ErrorCode errorCode = ErrorCode.NETWORK_ERROR;
            if (t instanceof InterruptedIOException) {
                failureMsg = ErrorMessage.CONNECT_TIMEOUT;
            } else if (t instanceof UnknownServiceException) {
                failureMsg = ErrorMessage.SERVICE_BUSY;
            } else if (t instanceof UnknownHostException) {
                failureMsg = ErrorMessage.UNKNOWN_HOST;

            } else if (t instanceof ConnectException) {
                failureMsg = ErrorMessage.CONNECT_ERROR;

            } else if (t instanceof SocketException) {
                failureMsg = ErrorMessage.SOCKET_ERROR;
            } else if (t instanceof JsonSyntaxException || t instanceof com.google.gson.stream.MalformedJsonException) {
                failureMsg = ErrorMessage.PROTOCOL_ERROR;
                errorCode = ErrorCode.PROTOCOL_ERROR;
            }
            failure(errorCode, failureMsg);
        }
    }

    /**
     * 网络访问、响应、协议解析成功时回调
     *
     * @param result
     * @param response
     */
    public abstract void success(@NonNull T result, Response<T> response);

    /**
     * 网络访问失败、协议解析错误、Http响应错误、Java异常失败回调。
     *
     * @param code
     * @param message
     */
    public abstract void failure(ErrorCode code, String message);
}
