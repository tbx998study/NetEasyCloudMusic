package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ILoginCallback;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface ILoginPresenter {

    void login(String phone, String pass);

    void registerCallback(ILoginCallback callback);

    void unRegisterCallback(ILoginCallback callback);
}
