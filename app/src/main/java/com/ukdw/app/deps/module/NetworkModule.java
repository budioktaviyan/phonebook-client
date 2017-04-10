package com.ukdw.app.deps.module;

import com.ukdw.app.services.Api;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Api provideApi() {
        final Retrofit retrofit = new Retrofit.Builder()
                                      .client(getOkHttpClient())
                                      .baseUrl("http://188.166.238.77")
                                      .addConverterFactory(GsonConverterFactory.create())
                                      .build();

        return retrofit.create(Api.class);
    }

    private OkHttpClient getOkHttpClient() {
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        return new OkHttpClient.Builder()
                   .connectTimeout(30, TimeUnit.SECONDS)
                   .readTimeout(15, TimeUnit.SECONDS)
                   .writeTimeout(15, TimeUnit.SECONDS)
                   .retryOnConnectionFailure(true)
                   .addNetworkInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
                   .build();
    }
}