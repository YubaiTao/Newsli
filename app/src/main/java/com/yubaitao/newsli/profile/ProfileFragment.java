package com.yubaitao.newsli.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.WebViewActivity;
import com.yubaitao.newsli.common.ViewModelAdapter;
import com.yubaitao.newsli.mvp.MVPFragment;
import com.yubaitao.newsli.profile.setting.SettingAboutFragment;
import com.yubaitao.newsli.profile.setting.SettingDonateFragment;
import com.yubaitao.newsli.save.detail.SavedNewsDetailedFragment;
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
        if (!viewModelAdapter.isEmpty()) {
            return;
        }
        viewModelAdapter.addViewModel(new TitleViewModel(getString(R.string.setting),
                R.layout.setting_title_layout));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.clear_cache),
                presenter.getCacheClearListener()));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.donate),
                getDonateFragmentListener()));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.about),
                getAboutFragmentListener()));

        viewModelAdapter.addViewModel(new TitleViewModel(getString(R.string.change_source),
                R.layout.setting_title_layout));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.us),
                presenter.getOnCountryChangeListener(getString(R.string.us))));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.de),
                presenter.getOnCountryChangeListener(getString(R.string.de))));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.cn),
                presenter.getOnCountryChangeListener(getString(R.string.cn))));

        viewModelAdapter.addViewModel(new RowTextViewModel(getString(R.string.jp),
                presenter.getOnCountryChangeListener(getString(R.string.jp))));

    }

    @Override
    public void onCacheCleared() {
        Toast.makeText(getContext(), "Cache has been cleared", Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener getDonateFragmentListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nsFragmentManager.doFragmentTransaction(SettingDonateFragment.newInstance());
            }
;        };
    }

    private View.OnClickListener getAboutFragmentListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nsFragmentManager.doFragmentTransaction(SettingAboutFragment.newInstance());
            }
        };
    }

}
