package com.polamrapps.promobi.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.polamrapps.promobi.R;
import com.polamrapps.promobi.databinding.ActivityMostPopularBinding;
import com.polamrapps.promobi.ui.adapter.MostPopularAdapter;
import com.polamrapps.promobi.utils.Constants;
import com.polamrapps.promobi.viewmodel.MostPopularViewModel;

public class MostPopularActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMostPopularBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_most_popular);

        MostPopularViewModel viewModel =
                ViewModelProviders.of(this).get(MostPopularViewModel.class);
        viewModel.getMostPopularResponse().observe(this, mostPopularResponse -> {
            Log.i(Constants.TAG, "onCreate: ");
            mProgressDialog.dismiss();
            if (mostPopularResponse != null) {
                Log.i(Constants.TAG, "onCreate: "+mostPopularResponse.getResultList().size());
                MostPopularAdapter adapter = new MostPopularAdapter(this,
                        mostPopularResponse.getResultList());
                binding.rvMostPopular.setLayoutManager(new LinearLayoutManager(this));
                binding.rvMostPopular.setAdapter(adapter);
            }
        });
    }
}
