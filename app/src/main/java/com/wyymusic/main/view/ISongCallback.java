package com.wyymusic.main.view;

import com.wyymusic.main.model.SongResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/9
 * target:
 * time: 2021/1/9
 * God Bless my code!
 **/
public interface ISongCallback {

    void onLoadedSongData(List<SongResponse.Data> data);
}
