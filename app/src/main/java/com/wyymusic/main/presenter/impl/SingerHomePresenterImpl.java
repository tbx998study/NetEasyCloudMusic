package com.wyymusic.main.presenter.impl;

import android.os.Handler;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.SingerHomeResponse;
import com.wyymusic.main.presenter.ISingerHomePresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ISingerHomeCallback;

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
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public class SingerHomePresenterImpl implements ISingerHomePresenter {

    private static final String REQ = "artist/detail?id=";
    private ISingerHomeCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getSingerHome(long id) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ + id).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                List<SingerHomeResponse> singerHomeResponses = JSONArray.parseArray(NetworkUtil.parseJSON(response.body().string()), SingerHomeResponse.class);
                if (singerHomeResponses != null) {
                    for (SingerHomeResponse homeRespons : singerHomeResponses) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mCallback.onLoadedSingerHomeData(homeRespons.getData());
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void registerCallback(ISingerHomeCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ISingerHomeCallback callback) {
        mCallback = null;
    }
}
