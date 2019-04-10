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
import com.polamrapps.promobi.model.MostPopular;
import com.polamrapps.promobi.databinding.ItemMostPopularBinding;
import com.polamrapps.promobi.listeners.MostPopularListener;
import com.polamrapps.promobi.ui.activity.DetailActivity;
import com.polamrapps.promobi.utils.Constants;

import java.util.List;

public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewModel>
        implements MostPopularListener {

    private final List<MostPopular> mData;
    private final Context mContext;

    public MostPopularAdapter(Context context, List<MostPopular> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public MostPopularViewModel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemMostPopularBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_most_popular, viewGroup, false);
        return new MostPopularViewModel(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MostPopularViewModel holder, int pos) {
        MostPopular mostPopular = mData.get(pos);
        holder.bind(mostPopular);
        holder.mBinding.setModel(mostPopular);
        holder.mBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemClick(MostPopular mostPopular) {
        Log.i(Constants.TAG, "onItemClick: "+mostPopular.getTitle());
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(Constants.TITLE, mostPopular.getTitle());
        intent.putExtra(Constants.URL, mostPopular.getDetailUrl());
        mContext.startActivity(intent);
    }

    public class MostPopularViewModel extends RecyclerView.ViewHolder {

        final ItemMostPopularBinding mBinding;

        MostPopularViewModel(ItemMostPopularBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(MostPopular mostPopular) {
            mBinding.tvDate.setText(String.format(mContext.getResources().getString(R.string.publish_date),
                    mostPopular.getDate()));
            Glide.with(mContext)
                    .load(mostPopular.getMediaList().get(0).getMediaMetaData().get(0).getImageUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mBinding.ivIcon);
            Log.i(Constants.TAG, "bind: "+mostPopular.getMediaList().get(0).getMediaMetaData().get(0).getImageUrl());
        }
    }
}
