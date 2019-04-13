package com.yubaitao.newsli.sli;

import com.yubaitao.newsli.mvp.MVPContract;
import com.yubaitao.newsli.retrofit.response.News;

import java.util.List;

public interface SliContract {
    interface View extends MVPContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
        void onError();
    }

    interface Presenter extends MVPContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavoriteNews(News news);
        void onError();
    }

    interface Model extends MVPContract.Model<Presenter> {
        void fetchData();

        void saveFavoriteNews(News news);
    }
}
