package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.ExistResponse;
import com.wyymusic.main.presenter.IUserIsExistPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.IUserIsExistCallback;

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
public class UserIsExistPresenterImpl implements IUserIsExistPresenter {

    private IUserIsExistCallback mCallback;
    private Handler mHandler = new Handler();
    private static final String REQ = "cellphone/existence/check?phone=";

    @Override
    public void judgeIsExist(String phoneNum) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ + phoneNum)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d("IsExist","请求失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d("IsExist","请求成功" + response.code());
                String result = response.body().string();
                List<ExistResponse> existResponses = JSONArray.parseArray(NetworkUtil.parseJSON(result), ExistResponse.class);
                for (final ExistResponse respons : existResponses) {
                    Log.d("IsExist","响应的结果===========>" + respons);
                    if (respons.getCode() == 200) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mCallback.isExist(respons);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void registerCallback(IUserIsExistCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(IUserIsExistCallback callback) {
        mCallback = null;
    }
}
