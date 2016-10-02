package com.werockstar.mvpgithubapi.service;


import com.werockstar.mvpgithubapi.model.GithubItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubService {

    @GET("users/{user}")
    Observable<GithubItem> getData(@Path("user") String username);
}
