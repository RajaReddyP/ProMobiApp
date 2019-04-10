package com.polamrapps.promobi.repo.local;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;

import io.reactivex.Observable;


public interface DataLocalRepo {

    Observable<MovieReviewResponse> getMovieReviews();
    Long addMovieReviews(MovieReviewResponse data);

    Observable<MostPopularResponse> getMostPopular();
    Long addMostPopular(MostPopularResponse data);

    Observable<TopStoriesResponse> getTopStories();
    Long addTopStories(TopStoriesResponse data);
}
