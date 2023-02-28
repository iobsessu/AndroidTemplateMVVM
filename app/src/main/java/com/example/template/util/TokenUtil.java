package com.example.template.util;

/**
 * Token管理工具类
 */
public class TokenUtil {

    private static String token;
    private static final String KEY_TOKEN = "key_token";

    public static void setToken(String str) {
        MMKVUtil.put(KEY_TOKEN, str);
        token = str;
    }

    public static String getToken() {
        return token;
    }

    public static void clearToken() {
        MMKVUtil.remove(KEY_TOKEN);
        token = null;
    }

    public static boolean hasToken() {
        return MMKVUtil.containsKey(KEY_TOKEN);
    }



}
