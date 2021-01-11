package com.wyymusic.main.presenter.impl;

import android.os.Handler;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.SingerHotSongsResponse;
import com.wyymusic.main.presenter.ISingerHotSongsPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ISingerHotSongsCallback;

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
public class SingerHotSongsPresenterImpl implements ISingerHotSongsPresenter {

    private static final String REQ = "artist/top/song?id=";
    private ISingerHotSongsCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getSingerHotSongs(long id) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ + id).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                List<SingerHotSongsResponse> singerHotSongsResponses = JSONArray.parseArray(NetworkUtil.parseJSON(response.body().string()), SingerHotSongsResponse.class);
                if (singerHotSongsResponses != null) {
                    for (SingerHotSongsResponse singerHotSongsRespons : singerHotSongsResponses) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mCallback.onLoadedHotSongsData(singerHotSongsRespons.getSongs());
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void registerCallback(ISingerHotSongsCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ISingerHotSongsCallback callback) {
        mCallback = null;
    }
}
