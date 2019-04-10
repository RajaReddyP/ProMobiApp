package com.polamrapps.promobi.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.polamrapps.promobi.R;
import com.polamrapps.promobi.databinding.ActivityMovieReviewsBinding;
import com.polamrapps.promobi.ui.adapter.MovieReviewAdapter;
import com.polamrapps.promobi.utils.Constants;
import com.polamrapps.promobi.viewmodel.MovieReviewsViewModel;

public class MoviesReviewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieReviewsBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_movie_reviews);

        MovieReviewsViewModel viewModel = ViewModelProviders.of(this).get(MovieReviewsViewModel.class);
        viewModel.getMovieReviewResponse().observe(this, movieReviewResponse -> {
            mProgressDialog.dismiss();
            if (movieReviewResponse != null) {
                Log.i(Constants.TAG,
                        "onChanged: movieReviewResponse-->" + movieReviewResponse.getResultList().size());
                MovieReviewAdapter adapter = new MovieReviewAdapter(this,
                        movieReviewResponse.getResultList());
                binding.rvMovieReview.setLayoutManager(new LinearLayoutManager(this));
                binding.rvMovieReview.setAdapter(adapter);
            }
        });
    }
}
