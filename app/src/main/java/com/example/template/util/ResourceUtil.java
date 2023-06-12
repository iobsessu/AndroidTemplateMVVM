package com.example.template.util;

import android.content.Context;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

import com.example.template.app.AppApplication;

public class ResourceUtil {

    public static String getString(@StringRes int resId) {
        return AppApplication.getInstance().getString(resId);
    }

    static int getColor(@ColorRes int color) {
        return AppApplication.getInstance().getColor(color);
    }

}
