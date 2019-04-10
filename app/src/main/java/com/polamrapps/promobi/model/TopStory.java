package com.polamrapps.promobi.model;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopStory {

    @PrimaryKey
    public int id;

    @SerializedName("multimedia")
    private List<TopStoriesMultiMedia> mImages;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("published_date")
    private String mSubSection;

    @SerializedName("url")
    private String mDetailUrl;

    public String getSubSection() {
        return mSubSection;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<TopStoriesMultiMedia> getImages() {
        return mImages;
    }

    public void setImages(List<TopStoriesMultiMedia> mImages) {
        this.mImages = mImages;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setSubSection(String mSubSection) {
        this.mSubSection = mSubSection;
    }

    public void setDetailUrl(String mDetailUrl) {
        this.mDetailUrl = mDetailUrl;
    }

    public String getDetailUrl() {
        return mDetailUrl;
    }
}
