package com.wyymusic.main.presenter;

import com.wyymusic.main.view.IHomePageBannerCallback;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface IHomePageBannerPresenter {

    void getHomePageBanner();

    void registerCallback(IHomePageBannerCallback callback);

    void unRegisterCallback(IHomePageBannerCallback callback);
}
