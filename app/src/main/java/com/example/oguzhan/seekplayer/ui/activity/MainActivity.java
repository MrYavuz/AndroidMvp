package com.example.oguzhan.seekplayer.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.oguzhan.seekplayer.R;
import com.example.oguzhan.seekplayer.base.BaseActivity;
import com.example.oguzhan.seekplayer.interfaces.MainView;
import com.example.oguzhan.seekplayer.models.Post;
import com.example.oguzhan.seekplayer.presenters.MainPresenter;
import com.example.oguzhan.seekplayer.services.RestClientManager;
import com.example.oguzhan.seekplayer.services.Retrofit.RetrofitManager;
import com.example.oguzhan.seekplayer.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oguzhan on 23.12.2017.
 */

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {

    @BindView(R.id.editText)
    EditText postNumberEdtxt;
    @BindView(R.id.button)
    Button getPostBtn;
    @BindView(R.id.textView1)
    TextView tv1;
    @BindView(R.id.textView2)
    TextView tv2;
    @BindView(R.id.textView3)
    TextView tv3;
    @BindView(R.id.textView4)
    TextView tv4;
    @BindView(R.id.commentBox)
    EditText commentBox;
    @BindView(R.id.getCommentBtn)
    Button getCommentBtn;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getPostBtn.setOnClickListener(this);
        getCommentBtn.setOnClickListener(this);

        presenter = new MainPresenter(this,new RestClientManager(new RetrofitManager()));
        //you can use other restclient library here.
        //to do that, replace RetrofitManager class with different implementation
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void showPost(Post post) {
        tv1.setText(post.getId());
        tv2.setText(post.getUserId());
        tv3.setText(post.getTitle());
        tv4.setText(post.getBody());
    }


    @Override
    public void showComments(String comments) {
        commentBox.setText(comments);
    }

    @Override
    public void showAlert(String message) {
        AppUtils.showSimpleAlertWithMessage(this,"",message);
    }

    @Override
    public void showProgressDialog(String message) {
        AppUtils.showProgressDialog(this,message);
    }

    @Override
    public void hideProgressDialog() {
        AppUtils.hideProgressDialog(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(getPostBtn)){
            presenter.getPost(postNumberEdtxt.getText().toString());
        }
        else if(view.equals(getCommentBtn)){
            presenter.getCommment(postNumberEdtxt.getText().toString());
        }
    }

}

