package com.example.bipin.mvvmtest.viewmodel.loginViewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by bipin on 6/2/18.
 */

public class LoginViewModel extends BaseObservable {

    private LoginListner loginListner;

    private String username, password;

    public LoginViewModel(LoginListner loginListner) {
        this.loginListner = loginListner;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


   public interface LoginListner {
        void onLoginButtonCLicked();
    }
}
