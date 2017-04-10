package com.ukdw.app.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ukdw.app.R;
import com.ukdw.app.deps.component.ApplicationProvider;
import com.ukdw.app.services.Api;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Api api;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((ApplicationProvider) getApplication()).provideApplicationComponent().inject(this);
    }
}