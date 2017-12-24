package com.example.oguzhan.seekplayer.interfaces;

import com.example.oguzhan.seekplayer.models.Post;

/**
 * Created by oguzhan on 22.12.2017.
 */

public interface MainView {

    void showPost(Post post);
    void showComments(String comments);
    void showAlert(String message);
    void showProgressDialog(String message);
    void hideProgressDialog();

}
