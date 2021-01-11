package com.wyymusic.main.presenter;

import com.wyymusic.main.view.IValidateCodeCallback;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface IValidateCodePresenter {

    void validateCode(String phoneNum,String code);

    void registerCallback(IValidateCodeCallback callback);

    void unRegisterCallback(IValidateCodeCallback callback);
}
