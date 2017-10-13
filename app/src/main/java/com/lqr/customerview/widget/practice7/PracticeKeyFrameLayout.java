package com.lqr.customerview.widget.practice7;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;

public class PracticeKeyFrameLayout extends RelativeLayout {

    PracticeKeyFrameView keyFrameView;
    Button animateBtn;

    public PracticeKeyFrameLayout(Context context) {
        super(context);
    }

    public PracticeKeyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeKeyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        keyFrameView = findViewById(R.id.keyFrameView);
        animateBtn = findViewById(R.id.animateBtn);

        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Keyframe keyframe1 = Keyframe.ofInt(0, 0); // 时间完成度为0时，值为0
                Keyframe keyframe2 = Keyframe.ofInt(0.5f, 100);// 时间完成度为一半时，值为100
                Keyframe keyframe3 = Keyframe.ofInt(1, 80);// 时间完成度为1时（既动画完成），值退到80
                PropertyValuesHolder pvh = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);
                ObjectAnimator.ofPropertyValuesHolder(keyFrameView, pvh).setDuration(1000).start();
            }
        });
    }
}
