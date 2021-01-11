package com.wyymusic.main.model;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class LoginErrorResponse {

    private String msg;
    private int code;
    private String message;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginErrorResponse{");
        sb.append("msg='").append(msg).append('\'');
        sb.append(", code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
