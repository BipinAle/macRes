package com.example.bipin.mvvmtest.di.modules.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bipin.mvvmtest.MyApplication;
import com.example.bipin.mvvmtest.di.scope.ApplicationScope;
import com.example.bipin.mvvmtest.model.preferences.PreferenceHelper;
import com.example.bipin.mvvmtest.model.preferences.PreferenceHelperImpl;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bipin on 2/2/18.
 */

@Module
public class PreferenceModule {

    private final MyApplication myApplication;

    public PreferenceModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @ApplicationScope
    public SharedPreferences provideSharedPref() {
        return PreferenceManager.getDefaultSharedPreferences(myApplication);
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        return new Gson();
    }

    @Provides
    @ApplicationScope
    public PreferenceHelper providePreferenceHelper(SharedPreferences sharedPreferences, Gson gson) {
        return new PreferenceHelperImpl(sharedPreferences, gson);
    }
}
