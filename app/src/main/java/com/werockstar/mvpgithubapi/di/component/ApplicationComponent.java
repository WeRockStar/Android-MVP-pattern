package com.werockstar.mvpgithubapi.di.component;


import com.werockstar.mvpgithubapi.di.module.ApplicationModule;
import com.werockstar.mvpgithubapi.di.module.HttpModule;
import com.werockstar.mvpgithubapi.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
