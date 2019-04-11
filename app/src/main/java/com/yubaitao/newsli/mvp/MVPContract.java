package com.yubaitao.newsli.mvp;

public interface MVPContract {
    interface View<P extends Presenter> {
        P getPresenter();
    }

    interface Presenter<V extends View, M extends Model> {
        void onCreate();

        void onViewAttached(V view);

        void onViewDetached();

        void onDestroy();
    }

    interface Model<P extends Presenter> {
        void setPresenter(P presenter);
    }
}
