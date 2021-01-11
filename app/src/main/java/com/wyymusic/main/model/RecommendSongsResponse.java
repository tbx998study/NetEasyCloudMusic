package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class RecommendSongsResponse {

    private boolean hasTaste;
    private int code;
    private int category;
    private List<Result> result;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RecommendSongsResponse{");
        sb.append("hasTaste=").append(hasTaste);
        sb.append(", code=").append(code);
        sb.append(", category=").append(category);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }

    public boolean isHasTaste() {
        return hasTaste;
    }

    public void setHasTaste(boolean hasTaste) {
        this.hasTaste = hasTaste;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result {
        private long id;
        private int type;
        private String name;
        private String copywriter;
        private String picUrl;
        private boolean canDislike;
        private long trackNumberUpdateTime;
        private long playCount;
        private int trackCount;
        private boolean highQuality;
        private String alg;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Result{");
            sb.append("id=").append(id);
            sb.append(", type=").append(type);
            sb.append(", name='").append(name).append('\'');
            sb.append(", copywriter='").append(copywriter).append('\'');
            sb.append(", picUrl='").append(picUrl).append('\'');
            sb.append(", canDislike=").append(canDislike);
            sb.append(", trackNumberUpdateTime=").append(trackNumberUpdateTime);
            sb.append(", playCount=").append(playCount);
            sb.append(", trackCount=").append(trackCount);
            sb.append(", highQuality=").append(highQuality);
            sb.append(", alg='").append(alg).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCopywriter() {
            return copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public boolean isCanDislike() {
            return canDislike;
        }

        public void setCanDislike(boolean canDislike) {
            this.canDislike = canDislike;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }
}
