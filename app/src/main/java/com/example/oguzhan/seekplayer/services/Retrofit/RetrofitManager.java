package com.example.oguzhan.seekplayer.services.Retrofit;

import com.example.oguzhan.seekplayer.interfaces.RequestListener;
import com.example.oguzhan.seekplayer.interfaces.RestService;
import com.example.oguzhan.seekplayer.models.Comment;
import com.example.oguzhan.seekplayer.models.Post;
import com.example.oguzhan.seekplayer.services.ServiceConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oguzhan on 22.12.2017.
 */

public class RetrofitManager implements RestService {

    private final RetrofitApiService service;

    public RetrofitManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
        okHttp.connectTimeout(60, TimeUnit.SECONDS);
        okHttp.addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
                .build();

        service = retrofit.create(RetrofitApiService.class);
    }


    @Override
    public void getPostAsync(String postId, RequestListener<Post> listener) {
        Call<Post> call = service.getPost(postId);
        call.enqueue(new RequestCallback<>(listener));
    }

    @Override
    public void getCommentsAsync(String postId, RequestListener<List<Comment>> listener) {
        Call<List<Comment>> call = service.getComment(postId);
        call.enqueue(new RequestCallback<>(listener));
    }
}
