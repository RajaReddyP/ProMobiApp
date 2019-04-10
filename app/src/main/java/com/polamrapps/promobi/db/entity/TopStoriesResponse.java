package com.polamrapps.promobi.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.polamrapps.promobi.db.DbConstants;
import com.polamrapps.promobi.model.TopStory;

import java.util.List;

@Entity(tableName = DbConstants.TABLE_TOP_STORIES)
public class TopStoriesResponse {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @SerializedName("results")
    @ColumnInfo(name = DbConstants.TOP_STORIES_RESPONSE)
    private List<TopStory> mResultsList;

    public List<TopStory> getResultsList() {
        return mResultsList;
    }

    public void setResultsList(List<TopStory> mResultsList) {
        this.mResultsList = mResultsList;
    }
}
