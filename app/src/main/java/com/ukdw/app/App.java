package com.ukdw.app;

import android.app.Application;

import com.ukdw.app.deps.component.ApplicationComponent;
import com.ukdw.app.deps.component.ApplicationProvider;
import com.ukdw.app.deps.component.DaggerApplicationComponent;
import com.ukdw.app.deps.module.NetworkModule;

public class App extends Application implements ApplicationProvider {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder().networkModule(new NetworkModule()).build();
    }

    @Override
    public ApplicationComponent provideApplicationComponent() {
        return component;
    }
}