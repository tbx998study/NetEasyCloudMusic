package com.wyymusic.main.presenter;

import com.wyymusic.main.view.IHotSearchDetailCallback;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface IHotSearchDetailPresenter {

    void getHotSearchList();

    void registerCallback(IHotSearchDetailCallback callback);

    void unRegisterCallback(IHotSearchDetailCallback callback);
}
