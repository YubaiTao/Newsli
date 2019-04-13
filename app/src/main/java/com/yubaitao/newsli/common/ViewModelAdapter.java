package com.yubaitao.newsli.common;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewModelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<BaseViewModel> viewModels;
    private final SparseArrayCompat<BaseViewModel> viewTypeMap;

    public ViewModelAdapter() {
        viewModels = new ArrayList<>();
        viewTypeMap = new SparseArrayCompat<>();
    }

    public void addViewModels(Collection<? extends BaseViewModel> viewModels) {
        this.viewModels.clear();
        this.viewTypeMap.clear();
        addAll(viewModels);
        notifyDataSetChanged();
    }

    public void addViewModel(BaseViewModel viewModel) {
        this.viewModels.add(viewModel);
        viewTypeMap.put(viewModel.getViewType(), viewModel);
        int position = getPosition(viewModel);
        notifyItemInserted(position);
    }

    public void removeViewModel(int position) {
        if (position < -1 || position >= viewModels.size()) {
            return;
        }
        viewModels.remove(position);
        notifyItemRemoved(position);
    }

    public void removeViewModel(BaseViewModel viewModel) {
        removeViewModel(getPosition(viewModel));
    }

    private int getPosition(BaseViewModel viewModel) {
        return viewModels.indexOf(viewModel);
    }

    private void addAll(Collection<? extends BaseViewModel> viewModels) {
        if (viewModels == null) {
            return;
        }
        for (BaseViewModel baseViewModel : viewModels) {
            this.viewModels.add(baseViewModel);

            // If there are multiple items of the same type the index will just update
            viewTypeMap.put(baseViewModel.getViewType(), baseViewModel);
        }
    }

    public boolean isEmpty() {
        return viewModels.isEmpty();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return viewTypeMap.get(i).createViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        viewModels.get(i).bindViewHolder(viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        return viewModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }
}
