package com.yubaitao.newsli.profile;

import com.yubaitao.newsli.NSApplication;
import com.yubaitao.newsli.database.AppDatabase;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProfileModel implements ProfileContract.Model {
    private ProfileContract.Presenter presenter;
    private AppDatabase db = NSApplication.getDatabase();


    @Override
    public void deleteAllNewsCache() {
        Disposable disposable = Completable.fromAction(() ->
                db.newsDao().deleteAllNews())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    presenter.onCacheCleared();
                }, error -> {

                });
    }

    @Override
    public void setDefaultCountry(String country) {

    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
