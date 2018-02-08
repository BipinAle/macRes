package com.example.bipin.mvvmtest.di.components;

import android.content.Context;

import com.example.bipin.mvvmtest.di.modules.app.ApplicationModule;
import com.example.bipin.mvvmtest.di.modules.app.NetworkModule;
import com.example.bipin.mvvmtest.di.scope.ApplicationScope;
import com.example.bipin.mvvmtest.model.api.ApiHelper;
import com.google.gson.Gson;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by bipin on 3/2/18.
 */

@ApplicationScope
@Component(modules = { NetworkModule.class, ApplicationModule.class})
public interface ApplicationComponent {
//    SharedPreferences sharedPreference();
//    PreferenceHelper preferenceHelper();

    Gson gson();

    Cache cache();

    HttpLoggingInterceptor httpLoggingInterceptor();

    OkHttpClient okHttpClient();

    Retrofit retrofit();

    ApiHelper apiHelper();

    Context context();


}
