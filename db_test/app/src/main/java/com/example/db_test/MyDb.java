package com.example.db_test;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyDb  extends Application {
    @Override
    public void onCreate() {

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .schemaVersion(2)
                .build();

//        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);


    }
}



