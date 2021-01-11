package com.wyymusic.main.model;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class SendResponse {

    private int code;
    private boolean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SendResponse{");
        sb.append("code=").append(code);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
