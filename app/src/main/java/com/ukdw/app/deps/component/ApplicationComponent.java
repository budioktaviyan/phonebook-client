package com.ukdw.app.deps.component;

import com.ukdw.app.deps.module.NetworkModule;
import com.ukdw.app.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}