package com.polamrapps.promobi.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.polamrapps.promobi.db.entity.MovieReviewResponse;
import com.polamrapps.promobi.repo.DataRepo;
import com.polamrapps.promobi.repo.DataRepoImpl;
import com.polamrapps.promobi.db.AppDatabase;
import com.polamrapps.promobi.repo.local.DataLocalRepoImpl;
import com.polamrapps.promobi.repo.local.DataLocalRepo;
import com.polamrapps.promobi.repo.remote.DataRemoteRepo;
import com.polamrapps.promobi.repo.remote.DataRemoteRepoImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import static com.polamrapps.promobi.utils.Constants.TAG;

public class MovieReviewsViewModel extends AndroidViewModel {

    private final MutableLiveData<MovieReviewResponse> mMovieReviewResponse = new MutableLiveData<>();
    private final Disposable disposable;

    public MovieReviewsViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "MovieReviewsViewModel: ");
        DataLocalRepo localRepo =
                new DataLocalRepoImpl(AppDatabase.getInstance(
                        application.getApplicationContext()).movieReviewDao());

        DataRemoteRepo remoteRepo = new DataRemoteRepoImpl();
        DataRepo reviewRepo = new DataRepoImpl(localRepo, remoteRepo);

        disposable = reviewRepo.getMovieReview()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieReviewResponse>() {
                    @Override
                    public void onNext(MovieReviewResponse response) {
                        Log.i(TAG, "onNext: ");
                        mMovieReviewResponse.setValue(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: e-->"+e.toString());
                        Log.i(TAG, "onError: cause-->"+e.getCause());
                        mMovieReviewResponse.postValue(null);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });
    }

    public LiveData<MovieReviewResponse> getMovieReviewResponse() {
        return mMovieReviewResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
