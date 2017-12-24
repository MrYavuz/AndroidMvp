package com.example.oguzhan.seekplayer.interfaces;

import com.example.oguzhan.seekplayer.models.Comment;
import com.example.oguzhan.seekplayer.models.Post;

import java.util.List;

/**
 * Created by oguzhan on 22.12.2017.
 */

// Implement this in your restclient library manager class
// In this project, 'Retrofit2' is used


public interface RestService {

    void getPostAsync(String postId,RequestListener<Post> listener);
    void getCommentsAsync(String postId,RequestListener<List<Comment>> listener);

}
