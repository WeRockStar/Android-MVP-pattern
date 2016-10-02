package com.werockstar.mvpgithubapi.di.component;

import com.werockstar.mvpgithubapi.di.module.ActivityModule;
import com.werockstar.mvpgithubapi.di.module.ApplicationModule;

import dagger.Component;

@Component(dependencies = ApplicationModule.class, modules = ActivityModule.class)
public interface ActivityComponent {
}
