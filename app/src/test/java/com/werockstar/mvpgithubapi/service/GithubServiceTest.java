package com.werockstar.mvpgithubapi.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.werockstar.mvpgithubapi.model.GithubItem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

import static org.junit.Assert.*;

public class GithubServiceTest {

    private NetworkBehavior behavior = NetworkBehavior.create();

    interface Service {
        @GET("users/{user}")
        Call<GithubItem> getData(@Path("user") String username);
    }

    @Rule
    public MockWebServer server = new MockWebServer();

    public Service service;

    public Retrofit retrofit;

    @Before
    public void serUp() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(Service.class);
    }

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

    @Test
    public void responseFromGithub() throws Exception {
        server.enqueue(new MockResponse().setBody("{\"login\":\"WeRockStar\"}"));
        Call<GithubItem> call = service.getData("werockstar");
        Response<GithubItem> response = call.execute();
        GithubItem body = response.body();
        assertEquals("WeRockStar", body.getLogin());
    }
}