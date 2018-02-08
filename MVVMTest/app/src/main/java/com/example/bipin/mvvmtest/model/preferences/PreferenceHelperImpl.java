package com.example.bipin.mvvmtest.model.preferences;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by bipin on 2/2/18.
 */

public class PreferenceHelperImpl<T> implements PreferenceHelper<T> {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public PreferenceHelperImpl(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }


    @Override
    public Observable<T> save(final String key, final T value) {

        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                sharedPreferences.edit().putString(key, gson.toJson(value)).apply();
                emitter.onNext(value);
                emitter.onComplete();
            }
        });
    }

    @Override
    public Observable<T> get(final String key, final Class<T> generics) {

        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                String json = sharedPreferences.getString(key, "");
                T myClass = gson.fromJson(json, generics);
                emitter.onNext(myClass);
                emitter.onComplete();


            }
        });
    }

    @Override
    public Observable<Boolean> clear() {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                sharedPreferences.edit().clear().apply();
                emitter.onNext(true);
                emitter.onComplete();

            }
        });
    }
}
