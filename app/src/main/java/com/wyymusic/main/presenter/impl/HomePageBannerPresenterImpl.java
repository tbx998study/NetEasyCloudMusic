package com.wyymusic.main.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.wyymusic.main.model.HomePageBannerResponse;
import com.wyymusic.main.presenter.HomePageService;
import com.wyymusic.main.presenter.IHomePageBannerPresenter;
import com.wyymusic.main.util.NetworkUtil;
import com.wyymusic.main.view.IHomePageBannerCallback;

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
public class HomePageBannerPresenterImpl implements IHomePageBannerPresenter {
    private static final String REQ = "/banner";
    private IHomePageBannerCallback mCallback;
    private Handler mHandler = new Handler();

    @Override
    public void getHomePageBanner() {
//        OkHttpClient client = new OkHttpClient();
//        final Request request = new Request.Builder().url(NetworkUtil.BASE_URL + REQ).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                List<HomePageBannerResponse> homePageBannerResponses = JSONArray.parseArray(NetworkUtil.parseJSON(response.body().string()), HomePageBannerResponse.class);
//                for (HomePageBannerResponse homePageBannerRespons : homePageBannerResponses) {
//                    List<HomePageBannerResponse.Banners> banners = homePageBannerRespons.getBanners();
//                    if (banners != null) {
//                        mHandler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                mCallback.onLoadedBannerData(banners);
//                            }
//                        });
//                    }
//                }
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl(NetworkUtil.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        HomePageService bannerService = retrofit.create(HomePageService.class);
        Call<HomePageBannerResponse> task = bannerService.getHomePageBanner();
        task.enqueue(new Callback<HomePageBannerResponse>() {
            @Override
            public void onResponse(Call<HomePageBannerResponse> call, Response<HomePageBannerResponse> response) {
                HomePageBannerResponse body = response.body();
                Log.d("Banner","banner code ===============>" + response.code());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mCallback.onLoadedBannerData(body.getBanners());
                    }
                });
            }

            @Override
            public void onFailure(Call<HomePageBannerResponse> call, Throwable t) {
                Log.d("Banner","banner code ===============>" + t.toString());
            }
        });
    }

    @Override
    public void registerCallback(IHomePageBannerCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unRegisterCallback(IHomePageBannerCallback callback) {
        mCallback = null;
    }
}
