package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class HomeRoundResponse {
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
        final StringBuffer sb = new StringBuffer("HomeRoundResponse{");
        sb.append("code=").append(code);
        sb.append(", data=").append(data);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public class Data {
        private int id;
        private String name;
        private String iconUrl;
        private String url;
        private boolean skinSupport;
        private String homepageMode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public boolean isSkinSupport() {
            return skinSupport;
        }

        public void setSkinSupport(boolean skinSupport) {
            this.skinSupport = skinSupport;
        }

        public String getHomepageMode() {
            return homepageMode;
        }

        public void setHomepageMode(String homepageMode) {
            this.homepageMode = homepageMode;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", iconUrl='").append(iconUrl).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append(", skinSupport=").append(skinSupport);
            sb.append(", homepageMode='").append(homepageMode).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
