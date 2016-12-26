package com.mvpwithapi.main;

import java.util.List;

import rx.Observable;

/**
 * Created by Hari Prasad on 12/27/16.
 */
public class MainModel implements MainMvp.Model {
    private MainRepo repository;

    public MainModel(MainRepo repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<MainBean>> users() {
        return repository.getUsers();
    }
}
