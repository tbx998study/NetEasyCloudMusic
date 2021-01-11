package com.wyymusic.main.view;

import com.wyymusic.main.model.RecommendSongsResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface IRecommendSongsCallback {

    void onLoadedRecommendSongsData(List<RecommendSongsResponse.Result> data);
}
