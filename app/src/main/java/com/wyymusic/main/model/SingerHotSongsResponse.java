package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public class SingerHotSongsResponse {
    private int code;
    private boolean more;
    private List<Songs> songs;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SingerHotSongsResponse{");
        sb.append("code=").append(code);
        sb.append(", more=").append(more);
        sb.append(", songs=").append(songs);
        sb.append('}');
        return sb.toString();
    }

    public class Songs {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
