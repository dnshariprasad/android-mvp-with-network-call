package com.mvpwithapi.network;

import com.mvpwithapi.network.Api;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hari Prasad on 12/26/16.
 */
@Module
public class NetworkModule {
    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)

                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public Api provideApiService() {
        return provideRetrofit().create(Api.class);
    }
}
