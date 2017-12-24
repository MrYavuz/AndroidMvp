package com.example.oguzhan.seekplayer.services;

import com.example.oguzhan.seekplayer.interfaces.RequestListener;
import com.example.oguzhan.seekplayer.interfaces.RestClient;
import com.example.oguzhan.seekplayer.interfaces.RestService;
import com.example.oguzhan.seekplayer.models.Comment;
import com.example.oguzhan.seekplayer.models.Post;

import java.util.List;

/**
 * Created by oguzhan on 22.12.2017.
 */

public class RestClientManager implements RestClient {

    private RestService service;

    public RestClientManager(RestService service) {
        this.service = service;
    }

    @Override
    public void getPostAsync(String postId, RequestListener<Post> listener) {
        service.getPostAsync(postId,listener);
    }

    @Override
    public void getCommentsAsync(String postId, RequestListener<List<Comment>> listener) {
        service.getCommentsAsync(postId,listener);
    }


}
