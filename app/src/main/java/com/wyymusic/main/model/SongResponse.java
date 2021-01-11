package com.wyymusic.main.model;

import java.util.List;

/**
 * @author tbx
 * @date 2021/1/9
 * target:
 * time: 2021/1/9
 * God Bless my code!
 **/
public class SongResponse {

    private List<Data> data;
    private int code;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SongResponse{");
        sb.append("data=").append(data);
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }

    public class Data {
        private long id;
        private String url;
        private long br;
        private long size;
        private String md5;
        private int code;
        private int expi;
        private String type;
        private int gain;
        private int fee;
        private int payed;
        private int flag;
        private boolean canExtend;
        private String level;
        private String encodeType;
        private FreeTrialPrivilege freeTrialPrivilege;
        private int urlSource;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getBr() {
            return br;
        }

        public void setBr(long br) {
            this.br = br;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getExpi() {
            return expi;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getGain() {
            return gain;
        }

        public void setGain(int gain) {
            this.gain = gain;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getEncodeType() {
            return encodeType;
        }

        public void setEncodeType(String encodeType) {
            this.encodeType = encodeType;
        }

        public FreeTrialPrivilege getFreeTrialPrivilege() {
            return freeTrialPrivilege;
        }

        public void setFreeTrialPrivilege(FreeTrialPrivilege freeTrialPrivilege) {
            this.freeTrialPrivilege = freeTrialPrivilege;
        }

        public int getUrlSource() {
            return urlSource;
        }

        public void setUrlSource(int urlSource) {
            this.urlSource = urlSource;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Data{");
            sb.append("id=").append(id);
            sb.append(", url='").append(url).append('\'');
            sb.append(", br=").append(br);
            sb.append(", size=").append(size);
            sb.append(", md5='").append(md5).append('\'');
            sb.append(", code=").append(code);
            sb.append(", expi=").append(expi);
            sb.append(", type='").append(type).append('\'');
            sb.append(", gain=").append(gain);
            sb.append(", fee=").append(fee);
            sb.append(", payed=").append(payed);
            sb.append(", flag=").append(flag);
            sb.append(", canExtend=").append(canExtend);
            sb.append(", level='").append(level).append('\'');
            sb.append(", encodeType='").append(encodeType).append('\'');
            sb.append(", freeTrialPrivilege=").append(freeTrialPrivilege);
            sb.append(", urlSource=").append(urlSource);
            sb.append('}');
            return sb.toString();
        }

        public class FreeTrialPrivilege {
            private boolean resConsumable;
            private boolean userConsumable;

            public boolean isResConsumable() {
                return resConsumable;
            }

            public void setResConsumable(boolean resConsumable) {
                this.resConsumable = resConsumable;
            }

            public boolean isUserConsumable() {
                return userConsumable;
            }

            public void setUserConsumable(boolean userConsumable) {
                this.userConsumable = userConsumable;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("FreeTrialPrivilege{");
                sb.append("resConsumable=").append(resConsumable);
                sb.append(", userConsumable=").append(userConsumable);
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
