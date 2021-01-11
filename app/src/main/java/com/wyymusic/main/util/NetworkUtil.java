package com.wyymusic.main.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class NetworkUtil {

    public static final String BASE_URL = "http://172.20.10.3:3000/";

    public static String parseJSON(String target) {
        return "[" + target + "]";
    }

    public static String getToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE);
        String token = preferences.getString("token", "");
        return token;
    }
}
