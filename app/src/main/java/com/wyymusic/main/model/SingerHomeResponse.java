package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public class SingerHomeResponse {

    private int code;
    private String message;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SingerHomeResponse{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public class Data {
        private int videoCount;
        private Artist artist;

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("videoCount=").append(videoCount);
            sb.append(", artist=").append(artist);
            sb.append('}');
            return sb.toString();
        }

        public class Artist {
            private long id;
            private String cover;
            private String name;
            private String briefDesc;
            private int albumSize;
            private int musicSize;
            private int mvSize;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public int getMvSize() {
                return mvSize;
            }

            public void setMvSize(int mvSize) {
                this.mvSize = mvSize;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Artist{");
                sb.append("id=").append(id);
                sb.append(", cover='").append(cover).append('\'');
                sb.append(", name='").append(name).append('\'');
                sb.append(", briefDesc='").append(briefDesc).append('\'');
                sb.append(", albumSize=").append(albumSize);
                sb.append(", musicSize=").append(musicSize);
                sb.append(", mvSize=").append(mvSize);
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
