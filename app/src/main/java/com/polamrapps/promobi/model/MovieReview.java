package com.polamrapps.promobi.model;

import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class MovieReview {

    @PrimaryKey
    public int id;

    @SerializedName("multimedia")
    private MovieReviewMultiMedia mMovieImage;

    @SerializedName("display_title")
    private String mDisplayTitle;

    @SerializedName("publication_date")
    private String mPublicationDate;

    @SerializedName("link")
    private Link mDetailLink;

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public String getDisplayTitle() {
        return mDisplayTitle;
    }

    public MovieReviewMultiMedia getMovieImage() {
        return mMovieImage;
    }

    public Link getDetailLink() {
        return mDetailLink;
    }

    public void setDisplayTitle(String mDisplayTitle) {
        this.mDisplayTitle = mDisplayTitle;
    }

    public void setPublicationDate(String mPublicationDate) {
        this.mPublicationDate = mPublicationDate;
    }

    public void setMovieImage(MovieReviewMultiMedia mMovieImage) {
        this.mMovieImage = mMovieImage;
    }

    public void setDetailLink(Link mDetailLink) {
        this.mDetailLink = mDetailLink;
    }
}
