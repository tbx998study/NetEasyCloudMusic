package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ISearchCallback;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface ISearchPresenter {

    void getSearchList(String keyWord);

    void registerCallback(ISearchCallback callback);

    void unRegisterCallback(ISearchCallback callback);
}
