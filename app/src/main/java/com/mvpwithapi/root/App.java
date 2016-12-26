package com.mvpwithapi.root;

import android.app.Application;

import com.mvpwithapi.main.MainModel;
import com.mvpwithapi.main.MainModule;
import com.mvpwithapi.network.NetworkModule;

/**
 * Created by Hari Prasad on 12/25/16.
 */

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mainModule(new MainModule())
                .networkModule(new NetworkModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
