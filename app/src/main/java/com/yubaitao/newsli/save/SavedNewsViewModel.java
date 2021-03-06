package com.yubaitao.newsli.save;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.BaseViewModel;
import com.yubaitao.newsli.common.NSFragmentManager;
import com.yubaitao.newsli.common.Util;
import com.yubaitao.newsli.retrofit.response.News;
import com.yubaitao.newsli.save.detail.SavedNewsDetailedFragment;

public class SavedNewsViewModel extends BaseViewModel<SavedNewsViewModel.SavedNewsViewHolder> {

    private News news;
    private NSFragmentManager fragmentManager;
    private static int[] ICON_ARRAY = new int[]{
            // TODO: Modify dummy image
            R.drawable.dummy_1,
            R.drawable.dummy_2,
            R.drawable.dummy_3,
            R.drawable.dummy_4,
            R.drawable.dummy_5,
            R.drawable.dummy_6
    };

    public SavedNewsViewModel(News news, NSFragmentManager fragmentManager) {
        super(R.layout.saved_news_item);
        this.news = news;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public SavedNewsViewHolder createItemViewHolder(View view) {
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void bindViewHolder(SavedNewsViewHolder holder) {
        if (!Util.isStringEmpty(news.author)) {
            holder.author.setText(news.author);
        }
        holder.author.setText(news.getAuthor());
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(getDrawable());
        holder.itemView.setOnClickListener(view -> {
            fragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
        });
        // TODO: add hover delete here.
    }

    @DrawableRes
    private int getDrawable() {
        // TODO: modify here to match other avatar images
        return ICON_ARRAY[(int)(Math.random()*6)];
    }


    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }
}
