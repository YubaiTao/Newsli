package com.yubaitao.newsli.sli;

import com.yubaitao.newsli.retrofit.response.News;

import java.util.List;

public class SliPresenter implements SliContract.Presenter {

    private SliContract.View view;
    private SliContract.Model model;

    SliPresenter() {
        this.model = new SliModel();
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onViewAttached(SliContract.View view) {
        this.view = view;
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void showNewsCard(List<News> newsList) {
        // Model call this
        if (view == null) {
            return;
        }
        view.showNewsCard(newsList);
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteNews(news);
    }

    @Override
    public void onError() {
        if (view != null) {
            view.onError();
        }
    }
}
