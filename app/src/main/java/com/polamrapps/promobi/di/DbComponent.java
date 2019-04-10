package com.polamrapps.promobi.di;

import com.polamrapps.promobi.db.AppDatabase;

public interface DbComponent {

    AppDatabase getDatabase();
}
