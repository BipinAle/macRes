package com.example.bipin.mvvmtest.di.modules.login;

import com.example.bipin.mvvmtest.viewmodel.loginViewModel.LoginViewModel;

/**
 * Created by bipin on 7/2/18.
 */

public class LoginModule {

    LoginViewModel.LoginListner loginListner;

    public LoginModule(LoginViewModel.LoginListner loginListner) {
        this.loginListner = loginListner;
    }

    LoginViewModel loginViewModel() {
        return new LoginViewModel(loginListner);
    }
}
