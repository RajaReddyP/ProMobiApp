package com.polamrapps.promobi.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.polamrapps.promobi.db.DbConstants;
import com.polamrapps.promobi.model.MovieReview;

import java.util.List;

@Entity(tableName = DbConstants.TABLE_MOVIE_REVIEW)
public class MovieReviewResponse {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @SerializedName("results")
    @ColumnInfo(name = DbConstants.MOVIE_REVIEW_RESPONSE)
    private List<MovieReview> mResultList;

    public List<MovieReview> getResultList() {
        return mResultList;
    }

    public void setResultList(List<MovieReview> mRatingsList) {
        this.mResultList = mRatingsList;
    }
}
