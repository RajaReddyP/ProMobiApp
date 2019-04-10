package com.polamrapps.promobi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

    @SerializedName("media-metadata")
    private List<MediaMetaData> mMediaMetaData;

    public List<MediaMetaData> getMediaMetaData() {
        return mMediaMetaData;
    }

    public void setMediaMetaData(List<MediaMetaData> mMediaMetaData) {
        this.mMediaMetaData = mMediaMetaData;
    }
}
