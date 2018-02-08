package com.example.bipin.mvvmtest.di.modules.app;

import android.content.Context;

import com.example.bipin.mvvmtest.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bipin on 3/2/18.
 */

@Module
public class ApplicationModule {
    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context.getApplicationContext();

    }

    @Provides
    @ApplicationScope
    public Context context() {
        return context;
    }
}
