package com.example.template.util;

import android.content.res.Resources;

import androidx.annotation.ArrayRes;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import com.example.template.R;
import com.example.template.app.AppApplication;

public class ResUtil {

    public static String getString(@StringRes int resId) {
        return AppApplication.getInstance().getString(resId);
    }

    public static int getColor(@ColorRes int color) {
        return AppApplication.getInstance().getColor(color);
    }

    public static Resources getResources() {
        return AppApplication.getInstance().getResources();
    }

    public static String[] getArray(@ArrayRes int resId) {
        return getResources().getStringArray(R.array.gender_values);
    }

}
