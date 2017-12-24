package com.example.oguzhan.seekplayer.services.Retrofit;

import com.example.oguzhan.seekplayer.interfaces.RequestListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by oguzhan on 22.12.2017.
 */

public class RequestCallback<T> implements Callback<T> {

    private RequestListener<T> listener;

    public RequestCallback(RequestListener<T> listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        listener.onResponseSuccess(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        listener.onResponseFailure(t);
    }


}
