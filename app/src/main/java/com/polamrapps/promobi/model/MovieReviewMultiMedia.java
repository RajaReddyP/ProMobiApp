package com.polamrapps.promobi.model;

import com.google.gson.annotations.SerializedName;

public class MovieReviewMultiMedia {

    @SerializedName("src")
    private String mImageSrc;

    public String getImageSrc() {
        return mImageSrc;
    }

    public void setImageSrc(String mImageSrc) {
        this.mImageSrc = mImageSrc;
    }
}
