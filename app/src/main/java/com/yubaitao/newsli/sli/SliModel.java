package com.yubaitao.newsli.sli;

import android.annotation.SuppressLint;

import com.yubaitao.newsli.NSApplication;
import com.yubaitao.newsli.database.AppDatabase;
import com.yubaitao.newsli.retrofit.NewsRequestAPI;
import com.yubaitao.newsli.retrofit.RetrofitClient;
import com.yubaitao.newsli.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SliModel implements SliContract.Model {

    private SliContract.Presenter presenter;

    private final NewsRequestAPI newsRequestAPI;

    private final AppDatabase db;

    public SliModel() {
        newsRequestAPI = RetrofitClient.getInstance().create(NewsRequestAPI.class);
        db = NSApplication.getDatabase();
    }

    @Override
    public void setPresenter(SliContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        newsRequestAPI.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                }, error -> {

                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Disposable disposable = Completable.fromAction(() -> db.newsDao().insertNews(news))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> {

                }, error -> {

                });
    }
}
