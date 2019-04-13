package com.yubaitao.newsli.save.detail;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.WebViewActivity;
import com.yubaitao.newsli.common.BaseViewModel;
import com.yubaitao.newsli.common.NSFragmentManager;

import static com.yubaitao.newsli.WebViewActivity.URL;

public class ReadmoreViewModel extends BaseViewModel<ReadmoreViewModel.ReadmoreViewModelHolder> {

    private final String uri;
    private final NSFragmentManager fragmentManager;

    public ReadmoreViewModel(String uri, NSFragmentManager fragmentManager) {
        super(R.layout.readmore_layout);
        this.uri = uri;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ReadmoreViewModelHolder createItemViewHolder(View view) {
        return new ReadmoreViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(ReadmoreViewModelHolder holder) {
        holder.readmore.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        holder.readmore.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(URL, uri);
            fragmentManager.startActivityWithBundle(WebViewActivity.class, false, bundle);
        });
    }

    static class ReadmoreViewModelHolder extends RecyclerView.ViewHolder {
        TextView readmore;

        public ReadmoreViewModelHolder(@NonNull View itemView) {
            super(itemView);
            readmore = itemView.findViewById(R.id.readmore);
        }
    }

}
