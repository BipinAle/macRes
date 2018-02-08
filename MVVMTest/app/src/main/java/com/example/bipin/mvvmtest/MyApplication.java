package com.example.bipin.mvvmtest;

import android.app.Activity;
import android.app.Application;

import com.example.bipin.mvvmtest.di.components.ApplicationComponent;
import com.example.bipin.mvvmtest.di.components.DaggerApplicationComponent;
import com.example.bipin.mvvmtest.di.modules.app.ApplicationModule;

/**
 * Created by bipin on 3/2/18.
 */

public class MyApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjectors();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void initializeInjectors() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }


}
