package com.wyymusic.main.view;

import com.wyymusic.main.model.SendResponse;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface ISendCodeCallback {

    void isSendSuccess(SendResponse sendResponse);
}
