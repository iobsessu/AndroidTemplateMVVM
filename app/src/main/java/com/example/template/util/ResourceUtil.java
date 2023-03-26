package com.example.template.util;

import androidx.annotation.StringRes;

import com.example.template.app.AppApplication;

public class ResourceUtil {

    public static String getString(@StringRes int resId) {
        return AppApplication.getInstance().getString(resId);
    }

}
