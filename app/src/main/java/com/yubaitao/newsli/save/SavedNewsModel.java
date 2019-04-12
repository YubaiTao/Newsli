package com.yubaitao.newsli.save;

import com.yubaitao.newsli.NSApplication;
import com.yubaitao.newsli.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SavedNewsModel implements SavedNewsContract.Model {

    private SavedNewsContract.Presenter presenter;

    private final AppDatabase db;

    SavedNewsModel() {
        db = NSApplication.getDatabase();
    }

    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        Disposable disposable = db.newsDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::loadSavedNews, error -> {
                   System.out.println("error");
                }, () -> {
                    System.out.println("complete");
                });
    }
}
