package com.wyymusic.main.presenter;

import com.wyymusic.main.view.IHomeRoundCallback;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface IHomeRoundPresenter {

    void getHomeRoundData();

    void registerCallback(IHomeRoundCallback callback);

    void unRegisterCallback(IHomeRoundCallback callback);
}
