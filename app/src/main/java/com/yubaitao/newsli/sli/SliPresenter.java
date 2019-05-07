package com.yubaitao.newsli.sli;

import com.yubaitao.newsli.profile.CountryEvent;
import com.yubaitao.newsli.retrofit.response.News;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        EventBus.getDefault().register(this);
    }

    @Override
    public void onViewAttached(SliContract.View view) {
        this.view = view;
        this.model.fetchData("us");
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CountryEvent countryEvent) {
        if (this.view != null) {
            model.fetchData(countryEvent.country);
        }
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
