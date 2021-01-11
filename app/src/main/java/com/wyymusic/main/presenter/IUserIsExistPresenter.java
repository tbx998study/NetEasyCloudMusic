package com.wyymusic.main.presenter;

import com.wyymusic.main.view.IUserIsExistCallback;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface IUserIsExistPresenter {

    void judgeIsExist(String phoneNum);

    void registerCallback(IUserIsExistCallback callback);

    void unRegisterCallback(IUserIsExistCallback callback);
}
