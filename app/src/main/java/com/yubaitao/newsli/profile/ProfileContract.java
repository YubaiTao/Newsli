package com.yubaitao.newsli.profile;

import com.yubaitao.newsli.mvp.MVPContract;

public interface ProfileContract {

    interface View extends MVPContract.View<Presenter> {
        void setView();

        void onCacheCleared();
    }

    interface Presenter extends MVPContract.Presenter<View, Model> {
        void onCacheCleared();

        android.view.View.OnClickListener getCacheClearListener();

        android.view.View.OnClickListener getOnCountryChangeListener(String country);

    }

    interface Model extends MVPContract.Model<Presenter> {
        void deleteAllNewsCache();

        void setDefaultCountry(String country);
    }
}
