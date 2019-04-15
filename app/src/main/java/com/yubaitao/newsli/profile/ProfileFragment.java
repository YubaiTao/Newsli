package com.yubaitao.newsli.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.ViewModelAdapter;
import com.yubaitao.newsli.mvp.MVPFragment;
import com.yubaitao.newsli.save.detail.TitleViewModel;


public class ProfileFragment extends MVPFragment<ProfileContract.Presenter> implements ProfileContract.View {

    private ViewModelAdapter viewModelAdapter;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(viewModelAdapter);
        return view;
    }

    @Override
    public ProfileContract.Presenter getPresenter() {
        return new ProfilePresenter();
    }

    @Override
    public void setView() {
        viewModelAdapter.addViewModel(new TitleViewModel(getString(R.string.setting),
                R.layout.setting_title_layout));
    }

    @Override
    public void onCacheCleared() {

    }
}
