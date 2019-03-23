package com.yubaitao.newsli.common;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yubaitao.newsli.R;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class NSBasicFragment extends Fragment {

    protected NSFragmentManager nsFragmentManager;
    private final String uuid = UUID.randomUUID().toString();

    public NSBasicFragment() {
        // Required empty public constructor
    }

    @CallSuper
    public void onAttach(Context context) {
        super.onAttach(context);
        nsFragmentManager = (NSFragmentManager) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nsbasic, container, false);
    }

    public String getFragmentTag() {
        return this.getClass().getName() + uuid;
    }

}
