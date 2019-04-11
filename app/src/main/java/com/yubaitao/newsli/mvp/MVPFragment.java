package com.yubaitao.newsli.mvp;

import android.os.Bundle;

import com.yubaitao.newsli.common.NSBasicFragment;

import javax.annotation.Nullable;

public abstract class MVPFragment<P extends MVPContract.Presenter> extends NSBasicFragment implements MVPContract.View<P> {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        if (presenter != null) {
            presenter.onCreate();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onViewAttached(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }

    public abstract P getPresenter();

}
