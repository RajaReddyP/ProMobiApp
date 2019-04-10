package com.polamrapps.promobi.model;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MostPopular {

    @PrimaryKey
    public long id;

    @SerializedName("published_date")
    private String mDate;

    @SerializedName("media")
    private List<Media> mMediaList;

    @SerializedName("url")
    private String mDetailUrl;

    @SerializedName("title")
    private String mTitle;

    public List<Media> getMediaList() {
        return mMediaList;
    }

    public void setMediaList(List<Media> mMediaList) {
        this.mMediaList = mMediaList;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getDetailUrl() {
        return mDetailUrl;
    }

    public void setDetailUrl(String mDetailUrl) {
        this.mDetailUrl = mDetailUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
