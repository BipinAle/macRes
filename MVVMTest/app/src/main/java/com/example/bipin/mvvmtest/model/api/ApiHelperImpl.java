package com.example.bipin.mvvmtest.model.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.bipin.mvvmtest.model.api.entities.User;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by bipin on 2/2/18.
 */

public class ApiHelperImpl implements ApiHelper {

    private final Context context;

    RetrofitInterface retrofitInterface;

    public ApiHelperImpl(Context context, Retrofit retrofit) {
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        this.context = context.getApplicationContext();
    }

    @Override
    public Observable<User> getLoginData() {
        return retrofitInterface.getUserCredentials("reecha", "original12", "password");
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
