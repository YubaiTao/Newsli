package com.yubaitao.newsli.sli;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.yubaitao.newsli.R;
import com.yubaitao.newsli.mvp.MVPFragment;
import com.yubaitao.newsli.retrofit.response.News;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SliGalleryFragment extends MVPFragment<SliContract.Presenter> implements SliNewsCard.OnSwipeListener, SliContract.View {


    private SwipePlaceHolderView mSwipeView;

    public static SliGalleryFragment newInstance() {

        Bundle args = new Bundle();

        SliGalleryFragment fragment = new SliGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sli_gallery, container, false);

        mSwipeView = view.findViewById(R.id.swipeView);
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                                .setPaddingTop(20)
                                .setRelativeScale(0.01f)
                                .setSwipeInMsgLayoutId(R.layout.sli_news_swipe_in_msg_view)
                                .setSwipeOutMsgLayoutId(R.layout.sli_news_swipe_out_msg_view));

        view.findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        view.findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });


        return view;
    }


    @Override
    public void showNewsCard(List<News> newsList) {
        for (News news : newsList) {
            SliNewsCard sliNewsCard = new SliNewsCard(news, mSwipeView, this);
            mSwipeView.addView(sliNewsCard);
        }
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "News have been saved before.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLike(News news) {
        presenter.saveFavoriteNews(news);
    }

    @Override
    public SliContract.Presenter getPresenter() {
        return new SliPresenter();
    }
}
