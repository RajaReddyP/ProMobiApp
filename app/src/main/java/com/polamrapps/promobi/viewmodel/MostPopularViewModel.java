package com.polamrapps.promobi.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.polamrapps.promobi.db.AppDatabase;
import com.polamrapps.promobi.db.entity.MostPopularResponse;
import com.polamrapps.promobi.repo.DataRepo;
import com.polamrapps.promobi.repo.DataRepoImpl;
import com.polamrapps.promobi.repo.local.DataLocalRepoImpl;
import com.polamrapps.promobi.repo.local.DataLocalRepo;
import com.polamrapps.promobi.repo.remote.DataRemoteRepo;
import com.polamrapps.promobi.repo.remote.DataRemoteRepoImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import static com.polamrapps.promobi.utils.Constants.TAG;

public class MostPopularViewModel extends AndroidViewModel {

    private final MutableLiveData<MostPopularResponse> mMostPopularResponse = new MutableLiveData<>();
    private final Disposable disposable;

    public MostPopularViewModel(@NonNull Application application) {
        super(application);


        DataLocalRepo localRepo =
                new DataLocalRepoImpl(AppDatabase.getInstance(
                        application.getApplicationContext()).movieReviewDao());
        DataRemoteRepo remoteRepo = new DataRemoteRepoImpl();
        DataRepo mostPopularRepo = new DataRepoImpl(localRepo, remoteRepo);
        disposable = mostPopularRepo.getMostPopular()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MostPopularResponse>() {
                    @Override
                    public void onNext(MostPopularResponse response) {
                        mMostPopularResponse.setValue(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMostPopularResponse.setValue(null);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });
    }

    public LiveData<MostPopularResponse> getMostPopularResponse() {
        return mMostPopularResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
