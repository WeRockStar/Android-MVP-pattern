package com.werockstar.mvpgithubapi.presenter;

import com.werockstar.mvpgithubapi.model.GithubItem;

public interface GithubPresenter {
    void onLoadData(String username);

    void onStop();

    interface View {
        void showLoading();
        void dismissLoading();
        void showGithubProfile(GithubItem githubItem);
    }
}
