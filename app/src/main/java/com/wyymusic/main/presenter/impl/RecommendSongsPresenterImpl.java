package com.wyymusic.main.presenter.impl;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.RecommendSongsResponse;
import com.wyymusic.main.presenter.HomePageService;
import com.wyymusic.main.presenter.IRecommendSongsPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.IRecommendSongsCallback;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class RecommendSongsPresenterImpl implements IRecommendSongsPresenter {

    private static final String REQ = "personalized?limit=5";
    private IRecommendSongsCallback mCallback;
    private Context mContext;
    private Handler mHandler = new Handler();

    @Override
    public void getRecommendSongsData() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d("RecommendSongs", "code =========================>" + response.code());
                String result = response.body().string();
                List<RecommendSongsResponse> recommendSongsResponses = JSONArray.parseArray(NetworkUtil.parseJSON(result), RecommendSongsResponse.class);
                if (recommendSongsResponses != null) {
                    for (RecommendSongsResponse songsRespons : recommendSongsResponses) {
                        mHandler.post(() -> mCallback.onLoadedRecommendSongsData(songsRespons.getResult()));
                    }
                }
            }
        });
    }

    @Override
    public void registerCallback(IRecommendSongsCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(IRecommendSongsCallback callback) {
        mCallback = null;
    }
}
