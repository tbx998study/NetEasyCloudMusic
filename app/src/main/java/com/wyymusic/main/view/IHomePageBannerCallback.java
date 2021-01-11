package com.wyymusic.main.view;

import com.wyymusic.main.model.HomePageBannerResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface IHomePageBannerCallback {

    void onLoadedBannerData(List<HomePageBannerResponse.Banners> banners);
}
