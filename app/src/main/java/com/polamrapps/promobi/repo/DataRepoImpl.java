package com.polamrapps.promobi.repo;

import android.util.Log;

import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;
import com.polamrapps.promobi.repo.local.DataLocalRepo;
import com.polamrapps.promobi.repo.remote.DataRemoteRepo;
import com.polamrapps.promobi.utils.Constants;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DataRepoImpl implements DataRepo {

    private final DataLocalRepo localRepo;
    private final DataRemoteRepo remoteRepo;

    public DataRepoImpl(DataLocalRepo local, DataRemoteRepo remote) {
        this.localRepo = local;
        this.remoteRepo = remote;
    }

    @Override
    public Observable<MovieReviewResponse> getMovieReview() {

        return remoteRepo.getMovieReviews()
                .onErrorResumeNext(exception -> {
                    Log.i(Constants.TAG, "getMovieReview: exception --> " + exception.toString());
                    return localRepo.getMovieReviews();
                }).doOnNext(reviewResponse -> {
                    Long id = localRepo.addMovieReviews(reviewResponse);
                    Log.i(Constants.TAG, "1 onNext: id-->" + id);
                }).subscribeOn(Schedulers.io());

    }

    @Override
    public Observable<TopStoriesResponse> getTopStories() {

        return remoteRepo.getTopStories()
                .onErrorResumeNext(exception -> {
                    Log.i(Constants.TAG, "getTopStories: exception --> " + exception.toString());
                    return localRepo.getTopStories();
                }).doOnNext(reviewResponse -> {
                    Long id = localRepo.addTopStories(reviewResponse);
                    Log.i(Constants.TAG, "getTopStories 1 onNext: id-->" + id);
                }).subscribeOn(Schedulers.io());

    }

    @Override
    public Observable<MostPopularResponse> getMostPopular() {

        return remoteRepo.getMostPopular()
                .onErrorResumeNext(exception -> {
                    Log.i(Constants.TAG, "getMostPopular: exception --> " + exception.toString());
                    return localRepo.getMostPopular();
                }).doOnNext(reviewResponse -> {
                    Long id = localRepo.addMostPopular(reviewResponse);
                    Log.i(Constants.TAG, " getMostPopular 1 onNext: id-->" + id);
                }).subscribeOn(Schedulers.io());

    }
}
