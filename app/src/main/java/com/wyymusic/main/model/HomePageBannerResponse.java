package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class HomePageBannerResponse {

    private List<Banners> banners;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<Banners> banners) {
        this.banners = banners;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HomePageBannerResponse{");
        sb.append("banners=").append(banners);
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }

    public class Banners {
        private String imageUrl;
        private long targetId;
        private Adid adid;
        private int targetType;
        private String titleColor;
        private String typeTitle;
        private String url;
        private boolean exclusive;
        private String monitorImpress;
        private String monitorClick;
        private String monitorType;
        private String monitorImpressList;
        private String monitorClickList;
        private String monitorBlackList;
        private String extMonitor;
        private String extMonitorInfo;
        private String adSource;
        private String adLocation;
        private String adDispatchJson;
        private String encodeId;
        private String program;
        private String event;
        private String video;
        private String song;
        private String scm;

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Banners{");
            sb.append("imageUrl='").append(imageUrl).append('\'');
            sb.append(", targetId=").append(targetId);
            sb.append(", adid=").append(adid);
            sb.append(", targetType=").append(targetType);
            sb.append(", titleColor='").append(titleColor).append('\'');
            sb.append(", typeTitle='").append(typeTitle).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append(", exclusive=").append(exclusive);
            sb.append(", monitorImpress='").append(monitorImpress).append('\'');
            sb.append(", monitorClick='").append(monitorClick).append('\'');
            sb.append(", monitorType='").append(monitorType).append('\'');
            sb.append(", monitorImpressList='").append(monitorImpressList).append('\'');
            sb.append(", monitorClickList='").append(monitorClickList).append('\'');
            sb.append(", monitorBlackList='").append(monitorBlackList).append('\'');
            sb.append(", extMonitor='").append(extMonitor).append('\'');
            sb.append(", extMonitorInfo='").append(extMonitorInfo).append('\'');
            sb.append(", adSource='").append(adSource).append('\'');
            sb.append(", adLocation='").append(adLocation).append('\'');
            sb.append(", adDispatchJson='").append(adDispatchJson).append('\'');
            sb.append(", encodeId='").append(encodeId).append('\'');
            sb.append(", program='").append(program).append('\'');
            sb.append(", event='").append(event).append('\'');
            sb.append(", video='").append(video).append('\'');
            sb.append(", song='").append(song).append('\'');
            sb.append(", scm='").append(scm).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public long getTargetId() {
            return targetId;
        }

        public void setTargetId(int targetId) {
            this.targetId = targetId;
        }

        public Adid getAdid() {
            return adid;
        }

        public void setAdid(Adid adid) {
            this.adid = adid;
        }

        public int getTargetType() {
            return targetType;
        }

        public void setTargetType(int targetType) {
            this.targetType = targetType;
        }

        public String getTitleColor() {
            return titleColor;
        }

        public void setTitleColor(String titleColor) {
            this.titleColor = titleColor;
        }

        public String getTypeTitle() {
            return typeTitle;
        }

        public void setTypeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isExclusive() {
            return exclusive;
        }

        public void setExclusive(boolean exclusive) {
            this.exclusive = exclusive;
        }

        public String getMonitorImpress() {
            return monitorImpress;
        }

        public void setMonitorImpress(String monitorImpress) {
            this.monitorImpress = monitorImpress;
        }

        public String getMonitorClick() {
            return monitorClick;
        }

        public void setMonitorClick(String monitorClick) {
            this.monitorClick = monitorClick;
        }

        public String getMonitorType() {
            return monitorType;
        }

        public void setMonitorType(String monitorType) {
            this.monitorType = monitorType;
        }

        public String getMonitorImpressList() {
            return monitorImpressList;
        }

        public void setMonitorImpressList(String monitorImpressList) {
            this.monitorImpressList = monitorImpressList;
        }

        public String getMonitorClickList() {
            return monitorClickList;
        }

        public void setMonitorClickList(String monitorClickList) {
            this.monitorClickList = monitorClickList;
        }

        public String getMonitorBlackList() {
            return monitorBlackList;
        }

        public void setMonitorBlackList(String monitorBlackList) {
            this.monitorBlackList = monitorBlackList;
        }

        public String getExtMonitor() {
            return extMonitor;
        }

        public void setExtMonitor(String extMonitor) {
            this.extMonitor = extMonitor;
        }

        public String getExtMonitorInfo() {
            return extMonitorInfo;
        }

        public void setExtMonitorInfo(String extMonitorInfo) {
            this.extMonitorInfo = extMonitorInfo;
        }

        public String getAdSource() {
            return adSource;
        }

        public void setAdSource(String adSource) {
            this.adSource = adSource;
        }

        public String getAdLocation() {
            return adLocation;
        }

        public void setAdLocation(String adLocation) {
            this.adLocation = adLocation;
        }

        public String getAdDispatchJson() {
            return adDispatchJson;
        }

        public void setAdDispatchJson(String adDispatchJson) {
            this.adDispatchJson = adDispatchJson;
        }

        public String getEncodeId() {
            return encodeId;
        }

        public void setEncodeId(String encodeId) {
            this.encodeId = encodeId;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }

        public String getScm() {
            return scm;
        }

        public void setScm(String scm) {
            this.scm = scm;
        }

        public class Adid {
        }
    }
}
