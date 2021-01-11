package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/10
 * target:
 * time: 2021/1/10
 * God Bless my code!
 **/
public class SingerResponse {

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
        final StringBuffer sb = new StringBuffer("SingerResponse{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public class Data {
        private int videoCount;
        private Identify identify;
        private Artist artist;
        private User user;

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public Identify getIdentify() {
            return identify;
        }

        public void setIdentify(Identify identify) {
            this.identify = identify;
        }

        public Artist getArtist() {
            return artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("videoCount=").append(videoCount);
            sb.append(", identify=").append(identify);
            sb.append(", artist=").append(artist);
            sb.append(", user=").append(user);
            sb.append('}');
            return sb.toString();
        }

        public class Artist {
            private long id;
            private String cover;
            private String name;
            private String briefDesc;

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

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Artist{");
                sb.append("id=").append(id);
                sb.append(", cover='").append(cover).append('\'');
                sb.append(", name='").append(name).append('\'');
                sb.append(", briefDesc='").append(briefDesc).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public class Identify {
            private String imageUrl;
            private String imageDesc;
            private String actionUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getImageDesc() {
                return imageDesc;
            }

            public void setImageDesc(String imageDesc) {
                this.imageDesc = imageDesc;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("Identify{");
                sb.append("imageUrl='").append(imageUrl).append('\'');
                sb.append(", imageDesc='").append(imageDesc).append('\'');
                sb.append(", actionUrl='").append(actionUrl).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public class User {
            private String backgroundUrl;
            private String signature;
            private String avatarUrl;

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("User{");
                sb.append("backgroundUrl='").append(backgroundUrl).append('\'');
                sb.append(", signature='").append(signature).append('\'');
                sb.append(", avatarUrl='").append(avatarUrl).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
