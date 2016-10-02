package com.werockstar.mvpgithubapi.presenter;

import android.util.Log;

import com.werockstar.mvpgithubapi.service.GithubService;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class GithubPresenterImpl implements GithubPresenter {

    private GithubPresenter.View view;
    private GithubService service;
    private CompositeSubscription subscription = new CompositeSubscription();
    private static final String TAG = "GithubPresenterImpl";

    public GithubPresenterImpl(View githubView, GithubService service) {
        this.view = githubView;
        this.service = service;
    }

    @Override
    public void onLoadData(String username) {
        view.showLoading();

        subscription.add(service.getData(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> view.dismissLoading())
                .subscribe(githubItem -> {
                    view.showGithubProfile(githubItem);
                }, throwable -> {
                    Log.d(TAG, throwable.getMessage());
                })
        );

    }

    @Override
    public void onStop() {
        subscription.clear();
    }

}
