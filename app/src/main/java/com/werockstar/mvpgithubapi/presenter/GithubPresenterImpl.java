package com.werockstar.mvpgithubapi.presenter;

import com.google.gson.GsonBuilder;
import com.werockstar.mvpgithubapi.model.GithubItem;
import com.werockstar.mvpgithubapi.service.GithubService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubPresenterImpl implements GithubPresenter {

    private GithubPresenter.View githubView;

    public GithubPresenterImpl(GithubPresenter.View githubView) {
        this.githubView = githubView;
    }

    @Override
    public void onLoadData(String username) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        Call<GithubItem> call = service.getData(username);
        call.enqueue(new Callback<GithubItem>() {
            @Override
            public void onResponse(Call<GithubItem> call, Response<GithubItem> response) {
                if (response.isSuccessful())
                    githubView.showGithubProfile(response.body());
            }

            @Override
            public void onFailure(Call<GithubItem> call, Throwable t) {
            }
        });
    }

}
