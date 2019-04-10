package com.polamrapps.promobi.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.polamrapps.promobi.db.AppDatabase;
import com.polamrapps.promobi.db.entity.TopStoriesResponse;
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

public class TopStoriesViewModel extends AndroidViewModel {

    private final MutableLiveData<TopStoriesResponse> mTopStoriesResponse = new MutableLiveData<>();
    private final Disposable disposable;

    public TopStoriesViewModel(@NonNull Application application) {
        super(application);

        DataLocalRepo localRepo =
                new DataLocalRepoImpl(AppDatabase.getInstance(
                        application.getApplicationContext()).movieReviewDao());
        DataRemoteRepo remoteRepo = new DataRemoteRepoImpl();
        DataRepo topStoriesRepo = new DataRepoImpl(localRepo, remoteRepo);
        disposable = topStoriesRepo.getTopStories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<TopStoriesResponse>() {
                    @Override
                    public void onNext(TopStoriesResponse response) {
                        Log.i(TAG, "onNext:TopStoriesResponse "+response.getResultsList().size());
                        mTopStoriesResponse.setValue(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTopStoriesResponse.setValue(null);
                        Log.i(TAG, "onError:TopStoriesResponse e-->"+e.toString());
                        Log.i(TAG, "onError:TopStoriesResponse e-->"+e.getCause());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete:TopStoriesResponse ");
                    }
                });
    }

    public LiveData<TopStoriesResponse> getTopStoriesResponse() {
        return mTopStoriesResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
