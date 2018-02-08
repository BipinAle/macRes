package com.example.bipin.mvvmtest.model.api.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by bipin on 2/2/18.
 */

@Parcel
public class User {

    @Nullable
    @SerializedName("access_token")
    public  String accessToken;

    @Nullable
    @SerializedName("token_type")
    public  String tokenType;

    @Nullable
    @SerializedName("expires_in")
    public  Integer expiresIn;

    @Nullable
    @SerializedName("username")
    public  String username;

    @Nullable
    @SerializedName("firstname")
    public  String firstName;

    @Nullable
    @SerializedName("lastname")
    public  String lastname;

    @Nullable
    @SerializedName("user_id")
    public  String userId;

    @Nullable
    @SerializedName("phone")
    public  String phone;

    @Nullable
    @SerializedName("email")
    public  String email;


    @Nullable
    @SerializedName("profilePicture")
    public  String profilePicture;


    @Nullable
    @SerializedName("error")
    public  String error;

    @Nullable
    @SerializedName("error_description")
    public  String errorDescription;
}
