package com.wyymusic.main.model;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class ExistResponse {

    private int exist;
    private String nickname;
    private String hasPassword;
    private int code;

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(String hasPassword) {
        this.hasPassword = hasPassword;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExistResponse{");
        sb.append("exist=").append(exist);
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", hasPassword='").append(hasPassword).append('\'');
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }
}
