package com.example.bipin.mvvmtest.di.components.login;

import com.example.bipin.mvvmtest.di.components.ApplicationComponent;
import com.example.bipin.mvvmtest.di.modules.login.LoginModule;
import com.example.bipin.mvvmtest.di.scope.ActivityScope;
import com.example.bipin.mvvmtest.view.LoginActivity;

import dagger.Component;

/**
 * Created by bipin on 3/2/18.
 */

@ActivityScope
@Component(modules = {LoginModule.class}, dependencies = ApplicationComponent.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);

}
