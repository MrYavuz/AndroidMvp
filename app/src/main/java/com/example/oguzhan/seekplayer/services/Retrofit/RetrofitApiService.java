package com.example.oguzhan.seekplayer.services.Retrofit;

import com.example.oguzhan.seekplayer.models.Comment;
import com.example.oguzhan.seekplayer.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by oguzhan on 22.12.2017.
 */

public interface RetrofitApiService {

    @GET("/posts/{postId}")
    Call<Post> getPost(@Path("postId") String postId);

    @GET("posts/{postId}/comments")
    Call<List<Comment>> getComment(@Path("postId") String postId);

}
