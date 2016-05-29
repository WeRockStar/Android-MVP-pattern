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
    @Rule
    public MockWebServer server;

    @Before
    public void serUp() {
        server = new MockWebServer();
    }


    @Test
    public void checkStatusCode() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200));

        assertEquals("HTTP/1.1 200 OK", new MockResponse().getStatus());
    }

    @Test
    public void responseUsernameFromGithub() throws Exception {
        MockResponse response = new MockResponse().setBody("{\"login\":\"WeRockStar\"}");
        server.enqueue(response);
        GithubItem item = new Gson().fromJson(response.getBody().readUtf8(), GithubItem.class);
        assertEquals("WeRockStar", item.getLogin());
    }

    @Test
    public void responseFullNameFromGithub() throws Exception {
        MockResponse response = new MockResponse().setBody("{\"name\":\"Kotchaphan Muangsan\"}");
        server.enqueue(response);
        GithubItem item = new Gson().fromJson(response.getBody().readUtf8(), GithubItem.class);
        assertEquals("Kotchaphan Muangsan", item.getFullName());
    }
}