package com.polamrapps.promobi.repo.local;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;
import com.polamrapps.promobi.repo.dao.DataDao;

import io.reactivex.Observable;

public class DataLocalRepoImpl implements DataLocalRepo {

    private final DataDao dataDao;

    public DataLocalRepoImpl(DataDao dao) {
        dataDao = dao;
    }

    @Override
    public Observable<MovieReviewResponse> getMovieReviews() {
        return Observable.fromCallable(() -> dataDao.getMovieReviews());
    }

    @Override
    public Long addMovieReviews(MovieReviewResponse data) {
        return dataDao.insertMovieReviews(data);
    }

    @Override
    public Observable<MostPopularResponse> getMostPopular() {
        return Observable.fromCallable(() -> dataDao.getMostPopularResponse());
    }

    @Override
    public Long addMostPopular(MostPopularResponse data) {
        return dataDao.insertMostPopular(data);
    }

    @Override
    public Observable<TopStoriesResponse> getTopStories() {
        return Observable.fromCallable(()-> dataDao.getTopStories());
    }

    @Override
    public Long addTopStories(TopStoriesResponse data) {
        return dataDao.insertTopStories(data);
    }
}
