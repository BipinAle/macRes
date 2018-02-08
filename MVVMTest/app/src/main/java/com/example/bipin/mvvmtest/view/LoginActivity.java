package com.example.bipin.mvvmtest.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.bipin.mvvmtest.MyApplication;
import com.example.bipin.mvvmtest.R;
import com.example.bipin.mvvmtest.databinding.ActivityMainBinding;
import com.example.bipin.mvvmtest.di.components.DaggerActivityComponent;
import com.example.bipin.mvvmtest.di.modules.login.LoginModule;
import com.example.bipin.mvvmtest.viewmodel.loginViewModel.LoginViewModel;

import javax.inject.Inject;

/**
 * Created by bipin on 5/2/18.
 */

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginViewModel viewModel;

    private ActivityMainBinding activityMainBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DaggerActivityComponent.builder()
                .applicationComponent(MyApplication.get(this).getApplicationComponent())
                .loginModule(new LoginModule((LoginViewModel.LoginListner) this))
                .build()
                .inject(this);
        activityMainBinding.setViewmodel(viewModel);


    }


}
