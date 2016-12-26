package com.mvpwithapi.root;

import com.mvpwithapi.main.MainActivity;
import com.mvpwithapi.main.MainModule;
import com.mvpwithapi.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hari Prasad on 12/25/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, MainModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
