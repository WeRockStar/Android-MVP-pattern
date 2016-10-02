package com.werockstar.mvpgithubapi.di.module;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.werockstar.mvpgithubapi.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    public Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    public InputMethodManager provideInputMethodManager(Activity activity) {
        return (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
    }
}
