package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.wyymusic.main.model.TopArtistResponse;
import com.wyymusic.main.presenter.HomePageService;
import com.wyymusic.main.presenter.ITopArtistsPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.ITopArtistsCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author tbx
 * @date 2021/1/8
 * target:
 * time: 2021/1/8
 * God Bless my code!
 **/
public class TopArtistPresenterImpl implements ITopArtistsPresenter {
    private ITopArtistsCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getTopArtistData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        HomePageService homePageService = retrofit.create(HomePageService.class);
        Call<TopArtistResponse> task = homePageService.getTopArtists();
        task.enqueue(new Callback<TopArtistResponse>() {
            @Override
            public void onResponse(Call<TopArtistResponse> call, Response<TopArtistResponse> response) {
                TopArtistResponse topArtistResponse = response.body();
                if (topArtistResponse != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback.onLoadedTopArtist(topArtistResponse.getList().getArtists());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<TopArtistResponse> call, Throwable t) {
                Log.d("TopA","data =======================>" +t.toString());
            }
        });
    }

    @Override
    public void registerCallback(ITopArtistsCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(ITopArtistsCallback callback) {
        mCallback = null;
    }
}
