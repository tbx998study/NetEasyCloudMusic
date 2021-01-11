package com.wyymusic.main.view;

import com.wyymusic.main.model.HomeRoundResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface IHomeRoundCallback {

    void onLoadedHomeRoundData(List<HomeRoundResponse.Data> data);
}
