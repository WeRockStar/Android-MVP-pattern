package com.werockstar.mvpgithubapi.di.component;

import com.werockstar.mvpgithubapi.di.module.ActivityModule;
import com.werockstar.mvpgithubapi.di.scope.PerActivity;
import com.werockstar.mvpgithubapi.view.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
}
