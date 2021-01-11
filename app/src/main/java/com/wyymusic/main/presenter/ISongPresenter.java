package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ISongCallback;

/**
 * @author tbx
 * @date 2021/1/9
 * target:
 * time: 2021/1/9
 * God Bless my code!
 **/
public interface ISongPresenter {

    void getSongData(long id);

    void registerCallback(ISongCallback callback);

    void unRegisterCallback(ISongCallback callback);
}
