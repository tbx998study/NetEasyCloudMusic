package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.R;
import com.wyymusic.main.model.LoginErrorResponse;
import com.wyymusic.main.model.UserResponse;
import com.wyymusic.main.presenter.ILoginPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ILoginCallback;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class LoginPresenterImpl implements ILoginPresenter {

    private static final String TAG = "LoginPresenterImpl";
    private ILoginCallback mCallback;
    private static final String REQ = "login/cellphone?phone=";
    private Handler mHandler = new Handler();

    @Override
    public void login(String phone, String pass) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(NetworkUtil.BASE_URL + REQ + phone + "&password=" + pass)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "请求失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                if (result.contains("密码错误")) {
                    List<LoginErrorResponse> errorResponseList = JSONArray.parseArray(NetworkUtil.parseJSON(result), LoginErrorResponse.class);
                    for (final LoginErrorResponse errorResponse : errorResponseList) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                UserResponse respons = new UserResponse();
                                respons.setError(errorResponse);
                                mCallback.loginInfo(respons);
                            }
                        });
                    }
                } else {
                    List<UserResponse> responses = JSONArray.parseArray(NetworkUtil.parseJSON(result), UserResponse.class);
                    for (final UserResponse respons : responses) {
                        Log.d(TAG, "请求成功 =========================>" + respons);
                        if (respons != null) {
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mCallback.loginInfo(respons);
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    @Override
    public void registerCallback(ILoginCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ILoginCallback callback) {
        mCallback = null;
    }
}
