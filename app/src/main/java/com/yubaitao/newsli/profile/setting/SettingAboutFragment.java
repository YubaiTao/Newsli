package com.yubaitao.newsli.profile.setting;


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
public class SettingAboutFragment extends NSBasicFragment {

    public static SettingAboutFragment newInstance() {
        return new SettingAboutFragment();
    }

    public SettingAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting_about, container, false);
    }

}
