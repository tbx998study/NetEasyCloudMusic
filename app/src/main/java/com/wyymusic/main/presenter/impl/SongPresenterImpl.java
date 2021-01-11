package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.SongResponse;
import com.wyymusic.main.presenter.ISongPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ISongCallback;

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
 * @date 2021/1/9
 * target:
 * time: 2021/1/9
 * God Bless my code!
 **/
public class SongPresenterImpl implements ISongPresenter {
    private static final String REQ = "song/url?id=";
    private ISongCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getSongData(long id) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ + id).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                List<SongResponse> songResponses = JSONArray.parseArray(NetworkUtil.parseJSON(result), SongResponse.class);
                for (SongResponse songRespons : songResponses) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.onLoadedSongData(songRespons.getData());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void registerCallback(ISongCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ISongCallback callback) {
        mCallback = null;
    }
}
