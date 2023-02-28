package com.example.template.app;

import android.app.Application;

import com.example.template.util.InitUtil;

public class AppApplication extends Application {

    private static AppApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        InitUtil.init(this);
        instance = this;
    }

    public static AppApplication getInstance() {
        if (instance == null) {
            throw new NullPointerException("please inherit BaseApplication or call setApplication.");
        }
        return instance;
    }
}
