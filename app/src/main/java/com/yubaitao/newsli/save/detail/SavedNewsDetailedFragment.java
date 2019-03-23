package com.yubaitao.newsli.save.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.NSBasicFragment;
import com.yubaitao.newsli.save.SavedNewsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsDetailedFragment extends NSBasicFragment {


    public static SavedNewsDetailedFragment newInstance() {
        Bundle args = new Bundle();

        SavedNewsDetailedFragment fragment = new SavedNewsDetailedFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public SavedNewsDetailedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_news_detailed, container, false);
    }

}
