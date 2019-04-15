package com.yubaitao.newsli.profile;

import com.yubaitao.newsli.NSApplication;
import com.yubaitao.newsli.database.AppDatabase;

public class ProfileModel implements ProfileContract.Model {
    private ProfileContract.Presenter presenter;
    private AppDatabase db = NSApplication.getDatabase();


    @Override
    public void deleteAllNewsCache() {

    }

    @Override
    public void setDefaultCountry(String country) {

    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
