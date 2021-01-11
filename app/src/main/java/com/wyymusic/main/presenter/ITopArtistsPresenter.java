package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ITopArtistsCallback;

/**
 * @author tbx
 * @date 2021/1/8
 * target:
 * time: 2021/1/8
 * God Bless my code!
 **/
public interface ITopArtistsPresenter {

    void getTopArtistData();

    void registerCallback(ITopArtistsCallback callback);

    void unRegisterCallback(ITopArtistsCallback callback);
}
