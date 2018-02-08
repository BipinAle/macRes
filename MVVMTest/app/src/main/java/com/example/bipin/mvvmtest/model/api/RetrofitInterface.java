package com.example.bipin.mvvmtest.model.api;

import com.example.bipin.mvvmtest.model.api.entities.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bipin on 2/2/18.
 */

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST("amtixToken")
    Observable<User> getUserCredentials(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String grantType);
}
