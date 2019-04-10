package com.polamrapps.promobi.network;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("movies/v2/reviews/picks.json?")
    Observable<MovieReviewResponse> getMovieReviews(@Query("api-key") String apiKey);

    @GET("mostpopular/v2/viewed/1.json")
    Observable<MostPopularResponse> getMostPopular(@Query("api-key") String apiKey);

    @GET("topstories/v2/movies.json")
    Observable<TopStoriesResponse> getTopStories(@Query("api-key") String apiKey);
}
