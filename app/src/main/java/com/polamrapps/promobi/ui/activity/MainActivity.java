package com.polamrapps.promobi.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.polamrapps.promobi.R;
import com.polamrapps.promobi.databinding.ActivityMainBinding;
import com.polamrapps.promobi.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnMovieReview.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoviesReviewActivity.class);
            intent.putExtra(Constants.TYPE, "Movie Reviews");
            startActivity(intent);
        });

        binding.btnPopular.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MostPopularActivity.class);
            intent.putExtra(Constants.TYPE, "Most Popular");
            startActivity(intent);
        });

        binding.btnTopStories.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TopStoriesActivity.class);
            intent.putExtra(Constants.TYPE, "Top Movie Stories");
            startActivity(intent);
        });
    }

}
