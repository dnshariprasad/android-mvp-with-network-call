package com.mvpwithapi.main;

import com.mvpwithapi.network.Api;
import com.mvpwithapi.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari Prasad on 12/27/16.
 */
@Module(includes = {NetworkModule.class})
public class MainModule {

    @Provides
    public MainMvp.Presenter provideMainActivityPresenter(MainMvp.Model model) {
        return new MainPresenter(model);
    }

    @Provides
    public MainMvp.Model provideMainActivityModel(MainRepo repository) {
        return new MainModel(repository);
    }

    @Singleton
    @Provides
    public MainRepo provideRepo(Api aoi) {
        return new MainRepo(aoi);
    }
}
