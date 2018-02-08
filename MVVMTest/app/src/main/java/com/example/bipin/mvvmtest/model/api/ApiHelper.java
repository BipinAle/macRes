package com.example.bipin.mvvmtest.model.api;

import com.example.bipin.mvvmtest.model.api.entities.User;

/**
 * Created by bipin on 2/2/18.
 */

public interface ApiHelper {
    io.reactivex.Observable<User> getLoginData();
 }
