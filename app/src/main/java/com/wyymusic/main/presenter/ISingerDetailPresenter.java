package com.wyymusic.main.presenter;

import com.wyymusic.main.view.ISingerDetailCallback;

/**
 * @author tbx
 * @date 2021/1/10
 * target:
 * time: 2021/1/10
 * God Bless my code!
 **/
public interface ISingerDetailPresenter {

    void getSingerDetail(long id);

    void registerCallback(ISingerDetailCallback callback);

    void unRegisterCallback(ISingerDetailCallback callback);
}
