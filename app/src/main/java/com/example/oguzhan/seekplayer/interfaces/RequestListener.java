package com.example.oguzhan.seekplayer.interfaces;

/**
 * Created by oguzhan on 22.12.2017.
 */

public interface RequestListener<T> {

    void onResponseSuccess(T response);
    void onResponseFailure(Throwable t);

}
