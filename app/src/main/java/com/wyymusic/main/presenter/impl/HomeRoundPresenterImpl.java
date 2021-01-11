package com.wyymusic.main.presenter.impl;

import android.os.Handler;

import com.wyymusic.main.model.HomeRoundResponse;
import com.wyymusic.main.presenter.HomePageService;
import com.wyymusic.main.presenter.IHomeRoundPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.IHomeRoundCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class HomeRoundPresenterImpl implements IHomeRoundPresenter {

    private IHomeRoundCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getHomeRoundData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        HomePageService homePageService = retrofit.create(HomePageService.class);
        Call<HomeRoundResponse> task = homePageService.getHomeRound();
        task.enqueue(new Callback<HomeRoundResponse>() {
            @Override
            public void onResponse(Call<HomeRoundResponse> call, Response<HomeRoundResponse> response) {
                HomeRoundResponse homeRoundResponse = response.body();

                if (homeRoundResponse != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.onLoadedHomeRoundData(homeRoundResponse.getData());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<HomeRoundResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void registerCallback(IHomeRoundCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(IHomeRoundCallback callback) {
        mCallback = null;
    }
}
