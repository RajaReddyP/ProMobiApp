package com.polamrapps.promobi.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.polamrapps.promobi.db.DbConstants;
import com.polamrapps.promobi.model.MostPopular;

import java.util.List;

@Entity(tableName = DbConstants.TABLE_MOST_POPULAR)
public class MostPopularResponse {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @SerializedName("results")
    @ColumnInfo(name = DbConstants.MOST_POPULAR_RESPONSE)
    private List<MostPopular> mResultList;

    public List<MostPopular> getResultList() {
        return mResultList;
    }

    public void setResultList(List<MostPopular> mList) {
        this.mResultList = mList;
    }
}
