package com.wyymusic.main.presenter.impl;

import android.os.Handler;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.model.SearchResponse;
import com.wyymusic.main.presenter.ISearchPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ISearchCallback;

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
public class SearchPresenterImpl implements ISearchPresenter {

    private ISearchCallback mCallback;
    private static final String REQ = "search?keywords=";
    private Handler mHandler = new Handler();

    @Override
    public void getSearchList(String keyWord) {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ + keyWord).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                List<SearchResponse> searchResponses = JSONArray.parseArray(NetworkUtil.parseJSON(response.body().string()), SearchResponse.class);
                for (SearchResponse searchRespons : searchResponses) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.onLoadedSearchData(searchRespons.getResult().getSongs());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void registerCallback(ISearchCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ISearchCallback callback) {
        mCallback = null;
    }
}
