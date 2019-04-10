package com.polamrapps.promobi.repo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;

@Dao
public interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMovieReviews(MovieReviewResponse list);

    @Query("SELECT * FROM MovieReviewResponse")
    MovieReviewResponse getMovieReviews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMostPopular(MostPopularResponse list);

    @Query("SELECT * FROM MostPopularResponse")
    MostPopularResponse getMostPopularResponse();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertTopStories(TopStoriesResponse list);

    @Query("SELECT * FROM TopStoriesResponse")
    TopStoriesResponse getTopStories();
}
