package com.lqr.customerview.widget.practice6;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;

public class PracticeObjectAnimatorLayout extends RelativeLayout {

    PracticeObjectAnimatorView mObjectAnimatorView;
    Button animateBtn;

    public PracticeObjectAnimatorLayout(Context context) {
        super(context);
    }

    public PracticeObjectAnimatorLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeObjectAnimatorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mObjectAnimatorView = findViewById(R.id.objectAnimatorView);
        animateBtn = findViewById(R.id.animateBtn);


        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator oa = ObjectAnimator.ofFloat(mObjectAnimatorView, "progress", 0, 65);
                oa.setDuration(1000);
                oa.setInterpolator(new FastOutSlowInInterpolator());
                oa.start();
            }
        });


    }

}