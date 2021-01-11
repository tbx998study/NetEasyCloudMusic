package com.wyymusic.main.model;

import java.io.Serializable;

/**
 * @author tbx
 * @date 2020/10/12
 * target:
 * time: 2020/10/12
 * God Bless my code!
 **/
public class DataBean implements Serializable {

    public int imageRes;

    public DataBean(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
