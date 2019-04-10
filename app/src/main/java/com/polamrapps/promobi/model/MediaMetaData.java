package com.polamrapps.promobi.model;

import com.google.gson.annotations.SerializedName;

public class MediaMetaData {

    @SerializedName("url")
    private String mImageUrl;

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
