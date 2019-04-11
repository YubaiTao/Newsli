package com.yubaitao.newsli.save;

import com.yubaitao.newsli.mvp.MVPContract;

public interface SavedNewsContract {

    interface View extends MVPContract.View<Presenter> {

    }

    interface Presenter extends MVPContract.Presenter<View, Model> {

    }

    interface Model extends MVPContract.Model<Presenter> {

    }
}
