package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ISingerHomeCallback;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public interface ISingerHomePresenter {

    void getSingerHome(long id);

    void registerCallback(ISingerHomeCallback callback);

    void unRegisterCallback(ISingerHomeCallback callback);
}
