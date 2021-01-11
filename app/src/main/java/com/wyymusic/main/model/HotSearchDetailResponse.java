package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class HotSearchDetailResponse {

    private int code;
    private List<Data> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HotSearchDetailResponse{");
        sb.append("code=").append(code);
        sb.append(", data=").append(data);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public class Data {
        private String searchWord;
        private long score;
        private String content;
        private int source;
        private int iconType;
        private String iconUrl;
        private String url;
        private String alg;

        public String getSearchWord() {
            return searchWord;
        }

        public void setSearchWord(String searchWord) {
            this.searchWord = searchWord;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getIconType() {
            return iconType;
        }

        public void setIconType(int iconType) {
            this.iconType = iconType;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("searchWord='").append(searchWord).append('\'');
            sb.append(", score=").append(score);
            sb.append(", content='").append(content).append('\'');
            sb.append(", source=").append(source);
            sb.append(", iconType=").append(iconType);
            sb.append(", iconUrl='").append(iconUrl).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append(", alg='").append(alg).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
