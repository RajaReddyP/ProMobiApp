package com.polamrapps.promobi.repo;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;

import io.reactivex.Observable;

public interface DataRepo {
    Observable<MovieReviewResponse> getMovieReview();
    Observable<MostPopularResponse> getMostPopular();
    Observable<TopStoriesResponse> getTopStories();
}
