package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.SingerResponse;
import com.wyymusic.main.presenter.ISingerDetailPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ISingerDetailCallback;

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
 * @date 2021/1/10
 * target:
 * time: 2021/1/10
 * God Bless my code!
 **/
public class SingerPresenterImpl implements ISingerDetailPresenter {
    private static final String REQ = "artist/detail?id=";
    private ISingerDetailCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getSingerDetail(long id) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ + id).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                List<SingerResponse> responses = JSONArray.parseArray(NetworkUtil.parseJSON(response.body().string()), SingerResponse.class);
                for (SingerResponse respons : responses) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.onLoadedSingerDetailData(respons.getData());
                        }
                    });
                }

            }
        });
    }

    @Override
    public void registerCallback(ISingerDetailCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ISingerDetailCallback callback) {
        mCallback = null;
    }
}
