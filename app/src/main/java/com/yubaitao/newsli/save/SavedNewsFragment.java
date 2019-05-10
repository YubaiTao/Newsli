package com.yubaitao.newsli.save;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.NSBasicFragment;
import com.yubaitao.newsli.common.NSFragmentManager;
import com.yubaitao.newsli.common.ViewModelAdapter;
import com.yubaitao.newsli.mvp.MVPFragment;
import com.yubaitao.newsli.retrofit.response.News;
import com.yubaitao.newsli.save.detail.SavedNewsDetailedFragment;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MVPFragment<SavedNewsContract.Presenter>
        implements SavedNewsContract.View {

    private ViewModelAdapter savedNewsAdapter;
    private TextView emptyState;
    private LinearLayoutManager linearLayoutManager;
    private int initPosition = -1;


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

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        emptyState = view.findViewById(R.id.empty_state);
        if (isViewEmpty()) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (savedNewsAdapter == null) {
            savedNewsAdapter = new ViewModelAdapter();
        }
        recyclerView.setAdapter(savedNewsAdapter);

        return view;
    }

    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (newsList.size() == 0) {
            emptyState.setVisibility(View.VISIBLE);
        } else {
            emptyState.setVisibility(View.GONE);
        }
        if (newsList != null) {
            List<SavedNewsViewModel> models = new LinkedList<>();
            for (News news : newsList) {
                models.add(new SavedNewsViewModel(news, nsFragmentManager));
            }
            savedNewsAdapter.addViewModels(models);
        }
    }

    @Override
    public boolean isViewEmpty() {
        return savedNewsAdapter == null || savedNewsAdapter.isEmpty();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        initPosition = linearLayoutManager.findFirstVisibleItemPosition();
    }
}
