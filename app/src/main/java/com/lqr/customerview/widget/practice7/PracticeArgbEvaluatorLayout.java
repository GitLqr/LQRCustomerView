package com.lqr.customerview.widget.practice7;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;

public class PracticeArgbEvaluatorLayout extends RelativeLayout {

    PracticeArgbEvaluatorView argbEvaluatorView;
    Button animateBtn;

    public PracticeArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public PracticeArgbEvaluatorLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeArgbEvaluatorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        argbEvaluatorView = findViewById(R.id.argbEvaluatorView);
        animateBtn = findViewById(R.id.animateBtn);

        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator oa = ObjectAnimator.ofInt(argbEvaluatorView, "color", 0xffff0000, 0xff00ff00);
                oa.setEvaluator(new ArgbEvaluator());
                oa.setDuration(1000);
                oa.start();
            }
        });
    }
}
