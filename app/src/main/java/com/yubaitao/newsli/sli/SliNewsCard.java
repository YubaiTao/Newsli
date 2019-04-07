package com.yubaitao.newsli.sli;


import com.mindorks.placeholderview.annotations.Resolve;
import com.squareup.picasso.Picasso;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.yubaitao.newsli.R;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.yubaitao.newsli.common.Util;
import com.yubaitao.newsli.retrofit.response.News;


@Layout(R.layout.sli_news_card)
public class SliNewsCard {
    @View(R.id.news_image)
    ImageView image;

    @View(R.id.news_title)
    TextView newsTitle;

    @View(R.id.news_description)
    TextView newsDescription;

    private final News news;
    private final SwipePlaceHolderView swipeView;
    private final OnSwipeListener onSwipeListener;

    public SliNewsCard(News news, SwipePlaceHolderView swipeView, OnSwipeListener onSwipeListener) {
        this.news = news;
        this.swipeView = swipeView;
        this.onSwipeListener = onSwipeListener;
    }

    @Resolve
    void onResolved(){
        if (Util.isStringEmpty(news.image)) {
            image.setImageResource(R.drawable.no_image_available);
        } else {
            Picasso.get().load(news.getImage()).into(image);
        }
        newsTitle.setText(news.getTitle());
        newsDescription.setText(news.getDescription());
    }
    @SwipeOut
    void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        swipeView.addView(this);
    }

    @SwipeCancelState
    void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }
    @SwipeIn
    void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
        onSwipeListener.onLike(news);
    }

    @SwipeInState
    void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

    interface OnSwipeListener {
        void onLike(News news);
    }
}
