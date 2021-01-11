package com.wyymusic.main.view;

import com.wyymusic.main.model.SingerHomeResponse;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public interface ISingerHomeCallback {

    void onLoadedSingerHomeData(SingerHomeResponse.Data data);
}
