package com.yubaitao.newsli.sli;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.NSBasicFragment;
import com.yubaitao.newsli.retrofit.response.News;

/**
 * A simple {@link Fragment} subclass.
 */
public class SliGalleryFragment extends NSBasicFragment implements SliNewsCard.OnSwipeListener {


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

        for (int i = 0; i < 50; i++) {
            News news = new News();
            news.image = "https://assets.vogue.com/photos/5a20250511b13f636dfc8df0/master/w_1560,c_limit/00-story-image-liu-yifei.jpg";
            news.title = "This is a test.";
            news.description = "Test description";
            news.author = "Tester";
            SliNewsCard sliNewsCard = new SliNewsCard(news, mSwipeView, this);
            mSwipeView.addView(sliNewsCard);
        }

        return view;
    }

    @Override
    public void onLike(News news) {

    }
}
