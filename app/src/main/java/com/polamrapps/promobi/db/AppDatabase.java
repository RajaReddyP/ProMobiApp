package com.polamrapps.promobi.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;
import com.polamrapps.promobi.repo.dao.DataDao;

@Database(entities = {MovieReviewResponse.class, MostPopularResponse.class, TopStoriesResponse.class},
        version = 2,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class,
                    DbConstants.DATABASE_NAME).build();
        }
        return instance;
    }

    public abstract DataDao movieReviewDao();
    //public abstract MostPopularDao mostPopularDao();
    //public abstract TopStoriesDao topStoriesDao();
}
