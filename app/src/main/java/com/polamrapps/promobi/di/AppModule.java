package com.polamrapps.promobi.di;

import android.content.Context;

import com.polamrapps.promobi.ProMobileApp;
import com.polamrapps.promobi.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    @Singleton
    @Provides
    Context provideContext(ProMobileApp application) {
        return application;
    }

    @Singleton
    @Provides
    static AppDatabase provideDatabase(Context context) {
        return AppDatabase.getInstance(context);
    }
}
