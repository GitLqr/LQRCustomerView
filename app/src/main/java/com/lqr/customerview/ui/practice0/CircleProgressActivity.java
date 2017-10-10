package com.lqr.customerview.ui.practice0;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import com.lqr.customerview.R;
import com.lqr.customerview.widget.practice0.CircleProgressView;


public class CircleProgressActivity extends AppCompatActivity {

    private final static String TAG = CircleProgressActivity.class.getSimpleName();
    private CircleProgressView mCpv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);

        mCpv = (CircleProgressView) findViewById(R.id.cpv);

        ValueAnimator va = ValueAnimator.ofFloat(0, 100);
        va.setDuration(4000);
        va.setInterpolator(new LinearInterpolator());
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float current = (float) valueAnimator.getAnimatedValue();
                mCpv.setCurrent((int) current);
            }
        });
        va.start();
        mCpv.setListener(new CircleProgressView.OnProgressListener() {
            @Override
            public void onStart() {
                Log.e(TAG, "开始");
            }

            @Override
            public void onProgress(float progress) {
                Log.e(TAG, "加载中：" + progress);
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "加载完毕");
            }
        });
    }
}
