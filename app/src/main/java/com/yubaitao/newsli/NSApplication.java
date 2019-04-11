package com.yubaitao.newsli;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.facebook.stetho.Stetho;
import com.yubaitao.newsli.database.AppDatabase;

public class NSApplication extends Application {
    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "ns_db").build();
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
