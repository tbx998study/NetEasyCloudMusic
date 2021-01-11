package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.wyymusic.main.R;
import com.wyymusic.main.model.HotSearchDetailResponse;
import com.wyymusic.main.presenter.IHotSearchDetailPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.IHotSearchDetailCallback;

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
public class HotSearchDetailPresenterImpl implements IHotSearchDetailPresenter {

    private static final String TAG = "HotSearchDetailPresenterImpl";
    private IHotSearchDetailCallback mCallback;
    private static final String REQ = "search/hot/detail";
    private Handler mHandler = new Handler();

    @Override
    public void getHotSearchList() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(NetworkUtil.BASE_URL + REQ)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                List<HotSearchDetailResponse> hotSearchDetailResponses = JSONArray.parseArray(NetworkUtil.parseJSON(result), HotSearchDetailResponse.class);
                if (hotSearchDetailResponses != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            for (HotSearchDetailResponse hotSearchDetailRespons : hotSearchDetailResponses) {
                                mCallback.onLoadedData(hotSearchDetailRespons.getData());
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void registerCallback(IHotSearchDetailCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(IHotSearchDetailCallback callback) {
        mCallback = null;
    }
}
