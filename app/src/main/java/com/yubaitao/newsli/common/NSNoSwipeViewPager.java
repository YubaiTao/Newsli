package com.yubaitao.newsli.common;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NSNoSwipeViewPager extends ViewPager {
    public NSNoSwipeViewPager(Context context) {
        super(context);
    }

    public NSNoSwipeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // return super.onInterceptTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // return super.onTouchEvent(ev);
        return false;
    }
}
