package com.yubaitao.newsli.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class NSBasicActivity extends AppCompatActivity implements NSFragmentManager {

    protected static final String BUNDLE = "bundle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    @Override
    public void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    protected abstract int getLayout();
}
