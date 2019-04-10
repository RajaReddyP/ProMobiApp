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
import com.polamrapps.promobi.model.MovieReview;
import com.polamrapps.promobi.databinding.ItemMovieReviewBinding;
import com.polamrapps.promobi.listeners.MovieReviewListener;
import com.polamrapps.promobi.ui.activity.DetailActivity;
import com.polamrapps.promobi.utils.Constants;

import java.util.List;

public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewAdapter.MovieReviewViewModel> implements MovieReviewListener {

    private final List<MovieReview> mData;
    private final Context mContext;

    public MovieReviewAdapter(Context context, List<MovieReview> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public MovieReviewViewModel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemMovieReviewBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_movie_review, viewGroup, false);
        return new MovieReviewViewModel(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieReviewViewModel holder, int pos) {
        MovieReview movieReview = mData.get(pos);
        holder.mBinding.setModel(movieReview);
        holder.bind(movieReview);
        holder.mBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onMovieReviewClick(MovieReview movieReview) {
        Log.i(Constants.TAG, "onMovieReviewClick: "+movieReview.getDetailLink().getTitle());
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(Constants.TITLE, movieReview.getDetailLink().getTitle());
        intent.putExtra(Constants.URL, movieReview.getDetailLink().getUrl());
        mContext.startActivity(intent);
    }

    public class MovieReviewViewModel extends RecyclerView.ViewHolder {

        final ItemMovieReviewBinding mBinding;

        MovieReviewViewModel(ItemMovieReviewBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(MovieReview movieReview) {
            mBinding.tvDate.setText(String.format(mContext.getResources().getString(R.string.publish_date),
                    movieReview.getPublicationDate()));
            Glide.with(mContext)
                    .load(movieReview.getMovieImage().getImageSrc())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mBinding.ivIcon);
            Log.i(Constants.TAG, "bind: "+movieReview.getMovieImage().getImageSrc());
        }
    }
}
