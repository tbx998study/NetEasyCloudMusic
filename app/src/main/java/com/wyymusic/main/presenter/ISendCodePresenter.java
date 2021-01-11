package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ISendCodeCallback;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface ISendCodePresenter {

    void sendCode(String phone);

    void registerCallback(ISendCodeCallback callback);

    void unRegisterCallback(ISendCodeCallback callback);
}
