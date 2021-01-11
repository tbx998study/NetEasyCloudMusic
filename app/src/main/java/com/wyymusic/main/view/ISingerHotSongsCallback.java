package com.wyymusic.main.view;

import com.wyymusic.main.model.SingerHotSongsResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public interface ISingerHotSongsCallback {

    void onLoadedHotSongsData(List<SingerHotSongsResponse.Songs> data);
}
