package com.example.template.util;

import android.app.Application;

/**
 * 初始化第三方工具类
 */
public class InitUtil {

    public static void init(Application application) {
        MMKVUtil.init(application);
    }
}
