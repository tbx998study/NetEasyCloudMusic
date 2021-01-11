package com.wyymusic.main.model;


import java.util.List;

/**
 * @author tbx
 * @date 2021/1/8
 * target:
 * time: 2021/1/8
 * God Bless my code!
 **/
public class TopArtistResponse {

    private AList list;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TopArtistResponse{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }

    public AList getList() {
        return list;
    }

    public void setList(AList list) {
        this.list = list;
    }

    public class AList {
        private List<Artists> artists;

        public List<Artists> getArtists() {
            return artists;
        }

        public void setArtists(List<Artists> artists) {
            this.artists = artists;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("AList{");
            sb.append("artists=").append(artists);
            sb.append('}');
            return sb.toString();
        }

        public class Artists {
            private String name;
            private long id;
            private long picId;
            private long img1v1Id;
            private String briefDesc;
            private String picUrl;
            private String img1v1Url;
            private int albumSize;
            private String trans;
            private int musicSize;
            private int topicPerson;
            private int lastRank;
            private long score;
            private String picId_str;
            private String img1v1Id_str;

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Artists{");
                sb.append("name='").append(name).append('\'');
                sb.append(", id=").append(id);
                sb.append(", picId=").append(picId);
                sb.append(", img1v1Id=").append(img1v1Id);
                sb.append(", briefDesc='").append(briefDesc).append('\'');
                sb.append(", picUrl='").append(picUrl).append('\'');
                sb.append(", img1v1Url='").append(img1v1Url).append('\'');
                sb.append(", albumSize=").append(albumSize);
                sb.append(", trans='").append(trans).append('\'');
                sb.append(", musicSize=").append(musicSize);
                sb.append(", topicPerson=").append(topicPerson);
                sb.append(", lastRank=").append(lastRank);
                sb.append(", score=").append(score);
                sb.append(", picId_str='").append(picId_str).append('\'');
                sb.append(", img1v1Id_str='").append(img1v1Id_str).append('\'');
                sb.append('}');
                return sb.toString();
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public long getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(long img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public int getTopicPerson() {
                return topicPerson;
            }

            public void setTopicPerson(int topicPerson) {
                this.topicPerson = topicPerson;
            }

            public int getLastRank() {
                return lastRank;
            }

            public void setLastRank(int lastRank) {
                this.lastRank = lastRank;
            }

            public long getScore() {
                return score;
            }

            public void setScore(long score) {
                this.score = score;
            }

            public String getPicId_str() {
                return picId_str;
            }

            public void setPicId_str(String picId_str) {
                this.picId_str = picId_str;
            }

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public class Alias {
            }
        }
    }
}
