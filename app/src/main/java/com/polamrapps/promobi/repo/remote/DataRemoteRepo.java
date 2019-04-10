package com.polamrapps.promobi.repo.remote;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;

import io.reactivex.Observable;

public interface DataRemoteRepo {
    Observable<MovieReviewResponse> getMovieReviews();
    Observable<MostPopularResponse> getMostPopular();
    Observable<TopStoriesResponse> getTopStories();
}
