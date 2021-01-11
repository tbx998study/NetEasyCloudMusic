package com.wyymusic.main.view;

import com.wyymusic.main.model.TopArtistResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/8
 * target:
 * time: 2021/1/8
 * God Bless my code!
 **/
public interface ITopArtistsCallback {

    void onLoadedTopArtist(List<TopArtistResponse.AList.Artists> data);
}
