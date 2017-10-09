package com.lqr.customerview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lqr.customerview.R;
import com.lqr.customerview.widget.PostManLoadingView;


public class PostManLoadingActivity extends AppCompatActivity {

    private PostManLoadingView mPmlv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_man_loading);
        mPmlv = (PostManLoadingView) findViewById(R.id.pmlv);
        mPmlv.start();
    }
}
