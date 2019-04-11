package com.yubaitao.newsli.save;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.NSBasicFragment;
import com.yubaitao.newsli.save.detail.SavedNewsDetailedFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends NSBasicFragment {


    public SavedNewsFragment() {
        // Required empty public constructor
    }

    public static SavedNewsFragment newInstance() {
        Bundle args = new Bundle();
        SavedNewsFragment fragment = new SavedNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_news, container, false);
        view.findViewById(R.id.text).setOnClickListener(v -> nsFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance()));
        return view;
    }

}
