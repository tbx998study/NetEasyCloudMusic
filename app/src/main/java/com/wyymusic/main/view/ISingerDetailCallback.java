package com.wyymusic.main.view;

import com.wyymusic.main.model.SingerResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/10
 * target:
 * time: 2021/1/10
 * God Bless my code!
 **/
public interface ISingerDetailCallback {

    void onLoadedSingerDetailData(SingerResponse.Data data);
}
