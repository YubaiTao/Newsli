package com.yubaitao.newsli;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class NSApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
