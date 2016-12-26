package com.mvpwithapi.network;

import com.mvpwithapi.main.MainBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Hari Prasad on 12/26/16.
 */

public interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com";

    @GET("/users")
    Observable<List<MainBean>> users();
}
