package com.wyymusic.main.view;

import com.wyymusic.main.model.SearchResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface ISearchCallback {

    void onLoadedSearchData(List<SearchResponse.Result.Songs> responses);
}
