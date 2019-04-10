package com.polamrapps.promobi.repo.remote;

import com.polamrapps.promobi.base.BaseRemote;
import com.polamrapps.promobi.base.RemoteConfiguration;
import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;
import com.polamrapps.promobi.network.GetDataService;
import com.polamrapps.promobi.utils.Constants;

import io.reactivex.Observable;

public class DataRemoteRepoImpl extends BaseRemote implements DataRemoteRepo {
    @Override
    public Observable<MovieReviewResponse> getMovieReviews() {
        return create(GetDataService.class, RemoteConfiguration.BASE_URL).getMovieReviews(Constants.API_KEY);
    }

    @Override
    public Observable<MostPopularResponse> getMostPopular() {
        return create(GetDataService.class, RemoteConfiguration.BASE_URL).getMostPopular(Constants.API_KEY);
    }

    @Override
    public Observable<TopStoriesResponse> getTopStories() {
        return create(GetDataService.class, RemoteConfiguration.BASE_URL).getTopStories(Constants.API_KEY);
    }
}
