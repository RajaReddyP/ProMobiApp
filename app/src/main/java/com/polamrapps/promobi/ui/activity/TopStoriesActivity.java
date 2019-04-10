package com.polamrapps.promobi.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.polamrapps.promobi.R;
import com.polamrapps.promobi.databinding.ActivityTopStoriesBinding;
import com.polamrapps.promobi.ui.adapter.TopStoriesAdapter;
import com.polamrapps.promobi.utils.Constants;
import com.polamrapps.promobi.viewmodel.TopStoriesViewModel;

public class TopStoriesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTopStoriesBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_top_stories);

        TopStoriesViewModel viewModel = ViewModelProviders.of(this).get(TopStoriesViewModel.class);
        viewModel.getTopStoriesResponse().observe(this, topStoriesResponse -> {
            mProgressDialog.dismiss();
            Log.i(Constants.TAG, "onChanged: ");
            if (topStoriesResponse != null) {
                TopStoriesAdapter adapter = new TopStoriesAdapter(this,
                        topStoriesResponse.getResultsList());
                binding.rvTopStories.setLayoutManager(new LinearLayoutManager(this));
                binding.rvTopStories.setAdapter(adapter);
            }
        });
    }
}
