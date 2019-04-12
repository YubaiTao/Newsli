package com.yubaitao.newsli.save;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.NSBasicFragment;
import com.yubaitao.newsli.common.NSFragmentManager;
import com.yubaitao.newsli.mvp.MVPFragment;
import com.yubaitao.newsli.retrofit.response.News;
import com.yubaitao.newsli.save.detail.SavedNewsDetailedFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsFragment extends MVPFragment<SavedNewsContract.Presenter>
        implements SavedNewsContract.View{

    private TextView author;
    private TextView description;

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

        author = view.findViewById(R.id.author);
        description = view.findViewById(R.id.description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nsFragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
            }
        });

        return view;
    }

    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (newsList.size() > 0) {
            News news = newsList.get(newsList.size() - 1);
            author.setText(news.getAuthor());
            description.setText(news.getDescription());
        }
    }
}
