package com.mvpwithapi.main;

import com.mvpwithapi.network.Api;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Hari Prasad on 12/27/16.
 */

public class MainRepo implements Repo {
    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds
    private Api api;
    private List<MainBean> results;
    private long timestamp;

    public MainRepo(Api api) {
        this.timestamp = System.currentTimeMillis();
        this.api = api;
        results = new ArrayList<>();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<List<MainBean>> getUsersFromMemory() {
        if (isUpToDate()) {
            return Observable.just(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<List<MainBean>> getUsersFromNetwork() {
        return api.users();
    }

    @Override
    public Observable<List<MainBean>> getUsers() {
        return getUsersFromMemory().switchIfEmpty(getUsersFromNetwork());
    }

    @Override
    public void saveUsers(List<MainBean> results) {
        this.results = results;
    }
}
