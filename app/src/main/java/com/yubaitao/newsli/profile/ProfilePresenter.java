package com.yubaitao.newsli.profile;

import android.view.View;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View view;
    private ProfileContract.Model model;

    ProfilePresenter() {
        this.model = new ProfileModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onCacheCleared() {
        if (view != null) {
            view.onCacheCleared();
        }
    }

    @Override
    public View.OnClickListener getCacheClearListener() {
        return view -> {
            model.deleteAllNewsCache();
        };
    }

    @Override
    public View.OnClickListener getOnCountryChangeListener(String country) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setDefaultCountry(country);
                // TODO: change the donate/about logic in the same way here.
            }
        };
//        return view -> {
//            model.setDefaultCountry(country);
//        };
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onViewAttached(ProfileContract.View view) {
        this.view = view;
        this.view.setView();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onDestroy() {

    }
}
