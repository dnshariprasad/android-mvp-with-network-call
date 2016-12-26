package com.mvpwithapi.main;

import com.mvpwithapi.network.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by Hari Prasad on 12/27/16.
 */

public class MainRepo implements Repo {
    private Api api;
    private List<MainBean> results;
    private long timestamp;

    public MainRepo(Api api) {
        this.timestamp = System.currentTimeMillis();
        this.api = api;
        results = new ArrayList<>();
    }

    @Override
    public Observable<List<MainBean>> getUsers() {
        return api.users();
    }

    @Override
    public void saveUsers(List<MainBean> results) {
        this.results = results;
    }


    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds


    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }
}
