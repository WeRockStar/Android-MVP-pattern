package com.werockstar.mvpgithubapi.service;

import org.junit.Test;

import retrofit2.Retrofit;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import static org.junit.Assert.*;

public class GithubServiceTest {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

    private NetworkBehavior behavior = NetworkBehavior.create();

    @Test
    public void networkRetrofit() {
        MockRetrofit mockRetrofit =
                new MockRetrofit.Builder(retrofit)
                        .build();
        assertNotNull(mockRetrofit.networkBehavior());
    }

    @Test
    public void networkBehavior() {
        MockRetrofit mockRetrofit =
                new MockRetrofit.Builder(retrofit)
                        .networkBehavior(behavior)
                        .build();

        assertSame(mockRetrofit.networkBehavior(), behavior);
    }
}