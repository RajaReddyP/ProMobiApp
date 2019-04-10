package com.polamrapps.promobi.ui.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.polamrapps.promobi.R;
import com.polamrapps.promobi.databinding.ActivityDetailBinding;
import com.polamrapps.promobi.utils.Constants;

public class DetailActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_detail);
        setSupportActionBar(binding.toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        init();

        binding.tvTitle.setText(getIntent().getStringExtra(Constants.TITLE));
        binding.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressDialog.dismiss();
            }
        });
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.loadUrl(getIntent().getStringExtra(Constants.URL));
        Log.i(Constants.TAG, "onCreate: "+getIntent().getStringExtra(Constants.URL));
    }

    private void init() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMax(100);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
