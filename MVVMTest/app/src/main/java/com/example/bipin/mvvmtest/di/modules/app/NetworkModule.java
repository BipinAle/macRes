package com.example.bipin.mvvmtest.di.modules.app;

import android.content.Context;

import com.example.bipin.mvvmtest.di.scope.ApplicationScope;
import com.example.bipin.mvvmtest.model.api.ApiHelper;
import com.example.bipin.mvvmtest.model.api.ApiHelperImpl;
import com.example.bipin.mvvmtest.utils.Constants;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bipin on 2/2/18.
 */
@Module
public class NetworkModule {


    @Provides
    @ApplicationScope

    public Cache cache(Context context) {
        return new Cache(new File(context.getCacheDir(), Constants.NetworkConstants.HTTP_DIR_CACHE), Constants.NetworkConstants.CACHE_SIZE);
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return httpLoggingInterceptor;
    }

    @Provides
    @ApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(Constants.NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Constants.NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        return new Gson();
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(Constants.ServerConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    @Provides
    @ApplicationScope
    public ApiHelper provideApiHelper(Context context, Retrofit retrofit) {
        return new ApiHelperImpl(context, retrofit);
    }


}
