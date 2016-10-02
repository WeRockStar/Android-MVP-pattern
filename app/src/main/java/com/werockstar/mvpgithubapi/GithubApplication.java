package com.werockstar.mvpgithubapi;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.werockstar.mvpgithubapi.di.component.ApplicationComponent;
import com.werockstar.mvpgithubapi.di.component.DaggerApplicationComponent;
import com.werockstar.mvpgithubapi.di.module.ApplicationModule;
import com.werockstar.mvpgithubapi.di.module.HttpModule;

import io.fabric.sdk.android.Fabric;

public class GithubApplication extends Application {

    ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
    }
}
