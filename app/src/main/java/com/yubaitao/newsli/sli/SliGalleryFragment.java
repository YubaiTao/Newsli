package com.yubaitao.newsli.sli;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.NSBasicFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SliGalleryFragment extends NSBasicFragment {


    public static SliGalleryFragment newInstance() {

        Bundle args = new Bundle();

        SliGalleryFragment fragment = new SliGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sli_gallery, container, false);
    }

}
