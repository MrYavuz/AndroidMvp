package com.example.oguzhan.seekplayer.interfaces;

import com.example.oguzhan.seekplayer.models.Comment;
import com.example.oguzhan.seekplayer.models.Post;

import java.util.List;

/**
 * Created by oguzhan on 22.12.2017.
 */

public interface RestClient {

     void getPostAsync(String postId,RequestListener<Post> listener);

     void getCommentsAsync(String postId,RequestListener<List<Comment>> listener);

}
