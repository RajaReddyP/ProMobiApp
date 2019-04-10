package com.polamrapps.promobi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.polamrapps.promobi.R;
import com.polamrapps.promobi.model.TopStory;
import com.polamrapps.promobi.databinding.ItemTopStoriesBinding;
import com.polamrapps.promobi.listeners.TopStoryListener;
import com.polamrapps.promobi.ui.activity.DetailActivity;
import com.polamrapps.promobi.utils.Constants;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewModel>
        implements TopStoryListener {

    private final List<TopStory> mData;
    private final Context mContext;

    public TopStoriesAdapter(Context context, List<TopStory> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public TopStoriesViewModel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemTopStoriesBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_top_stories, viewGroup, false);
        return new TopStoriesViewModel(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoriesViewModel holder, int pos) {
        TopStory topStory = mData.get(pos);
        holder.bind(topStory);
        holder.mBinding.setModel(topStory);
        holder.mBinding.setItemClickListener(this);
    }

    @Override
    public void onItemClick(TopStory topStory) {
        Log.i(Constants.TAG, "onItemClick: "+topStory.getSubSection());
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(Constants.TITLE, topStory.getTitle());
        intent.putExtra(Constants.URL, topStory.getDetailUrl());
        mContext.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class TopStoriesViewModel extends RecyclerView.ViewHolder {

        final ItemTopStoriesBinding mBinding;

        TopStoriesViewModel(ItemTopStoriesBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(TopStory mostPopular) {
            mBinding.tvDate.setText(String.format(mContext.getResources().getString(R.string.publish_date),
                    mostPopular.getSubSection()));
            String imageUrl = "";
            if (!mostPopular.getImages().isEmpty()) {
                imageUrl = mostPopular.getImages().get(0).getImageSrc();
            }
            Glide.with(mContext).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(mBinding.ivIcon);
        }
    }
}
