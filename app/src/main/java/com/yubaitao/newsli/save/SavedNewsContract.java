package com.yubaitao.newsli.save;

import com.yubaitao.newsli.mvp.MVPContract;
import com.yubaitao.newsli.retrofit.response.News;

import java.util.List;

public interface SavedNewsContract {

    interface View extends MVPContract.View<Presenter> {
        void loadSavedNews(List<News> newsList);
    }

    interface Presenter extends MVPContract.Presenter<View, Model> {
        void loadSavedNews(List<News> newsList);
    }

    interface Model extends MVPContract.Model<Presenter> {
        void fetchData();
    }
}
