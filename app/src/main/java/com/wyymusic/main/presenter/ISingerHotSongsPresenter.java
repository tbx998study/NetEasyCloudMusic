package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ISingerHotSongsCallback;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public interface ISingerHotSongsPresenter {

    void getSingerHotSongs(long id);

    void registerCallback(ISingerHotSongsCallback callback);

    void unRegisterCallback(ISingerHotSongsCallback callback);
}
