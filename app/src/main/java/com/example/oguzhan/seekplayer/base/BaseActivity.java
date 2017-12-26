package com.example.oguzhan.seekplayer.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by oguzhan on 24.12.2017.
 * To be extended by all Activities
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //bind view here for all activities extending this Activity
        ButterKnife.bind(this);

    }

    /**
     * get layout to inflate
     */
    public abstract
    @LayoutRes
    int getLayout();


}
