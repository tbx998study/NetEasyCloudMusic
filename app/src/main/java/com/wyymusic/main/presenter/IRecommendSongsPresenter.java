package com.wyymusic.main.presenter;

import android.content.Context;

import com.wyymusic.main.view.IRecommendSongsCallback;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface IRecommendSongsPresenter {

    void getRecommendSongsData();

    void registerCallback(IRecommendSongsCallback callback);

    void unRegisterCallback(IRecommendSongsCallback callback);
}
