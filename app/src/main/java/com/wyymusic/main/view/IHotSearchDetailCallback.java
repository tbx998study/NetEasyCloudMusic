package com.wyymusic.main.view;


import com.wyymusic.main.model.HotSearchDetailResponse;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public interface IHotSearchDetailCallback {

    void onLoadedData(List<HotSearchDetailResponse.Data> data);
}
