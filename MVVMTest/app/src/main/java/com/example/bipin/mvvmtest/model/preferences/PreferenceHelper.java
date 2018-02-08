package com.example.bipin.mvvmtest.model.preferences;

import io.reactivex.Observable;

/**
 * Created by bipin on 2/2/18.
 */

public interface PreferenceHelper<T> {

    Observable<T> save(String key, T value);

    Observable<T> get(String key, Class<T> generics);

    Observable<Boolean> clear();
}
