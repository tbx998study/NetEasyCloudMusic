package com.wyymusic.main.presenter.impl;

import com.wyymusic.main.presenter.ISendCodePresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ISendCodeCallback;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

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
public class SendCodePresenterImpl implements ISendCodePresenter {

    private ISendCodeCallback mCallback;
    private static final String REQ = "captcha/sent?phone=";

    @Override
    public void sendCode(String phone) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(NetworkUtil.BASE_URL + REQ + phone)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });
    }

    @Override
    public void registerCallback(ISendCodeCallback callback) {
        this.mCallback= callback;
    }

    @Override
    public void unRegisterCallback(ISendCodeCallback callback) {
        mCallback = null;
    }
}
