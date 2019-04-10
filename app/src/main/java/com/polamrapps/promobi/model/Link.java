package com.polamrapps.promobi.model;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("url")
    private String mUrl;

    @SerializedName("suggested_link_text")
    private String mTitle;

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }
}
