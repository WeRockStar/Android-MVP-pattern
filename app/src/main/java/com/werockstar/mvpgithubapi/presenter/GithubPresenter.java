package com.werockstar.mvpgithubapi.presenter;

import com.werockstar.mvpgithubapi.model.GithubItem;

public interface GithubPresenter {
    void onLoadData(String username);

    interface View {
        void showGithubProfile(GithubItem githubItem);
    }
}
