package com.yubaitao.newsli.save.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yubaitao.newsli.R;
import com.yubaitao.newsli.common.BaseViewModel;

public class ImageViewModel extends BaseViewModel<ImageViewModel.ImageViewModelViewHolder> {

    private final String uri;

    public ImageViewModel(String uri) {
        super(R.layout.image_layout);
        this.uri = uri;
    }

    @Override
    public ImageViewModelViewHolder createItemViewHolder(View view) {
        return new ImageViewModelViewHolder(view);
    }

    @Override
    public void bindViewHolder(ImageViewModelViewHolder holder) {
        Picasso.get().load(uri).into(holder.image);
    }

    static class ImageViewModelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        ImageViewModelViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
