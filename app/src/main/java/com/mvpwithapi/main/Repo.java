package com.mvpwithapi.main;

import java.util.List;

import rx.Observable;

/**
 * Created by Hari Prasad on 12/27/16.
 */

public interface Repo {
    Observable<List<MainBean>> getUsers();

    void saveUsers(List<MainBean> user);
}
