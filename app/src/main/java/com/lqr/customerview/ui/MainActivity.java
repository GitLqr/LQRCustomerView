package com.lqr.customerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lqr.customerview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CircleProgressView(View view) {
        startActivity(new Intent(this, CircleProgressActivity.class));
    }

    public void PostManLoadingView(View view) {
        startActivity(new Intent(this, PostManLoadingActivity.class));
    }
}
