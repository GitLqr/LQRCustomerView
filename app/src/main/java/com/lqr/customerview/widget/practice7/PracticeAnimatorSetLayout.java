package com.lqr.customerview.widget.practice7;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;


public class PracticeAnimatorSetLayout extends RelativeLayout {

    ImageView imageView;
    Button animateBtn;

    public PracticeAnimatorSetLayout(Context context) {
        super(context);
    }

    public PracticeAnimatorSetLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeAnimatorSetLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        imageView = findViewById(R.id.imageView);
        animateBtn = findViewById(R.id.animateBtn);
        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setTranslationX(-200f);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1); // 时间：300ms
                ObjectAnimator translationX = ObjectAnimator.ofFloat(imageView, "translationX", -200, 200);// 时间：300ms
                ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0, 1080);// 时间：1000ms
                rotation.setDuration(1000);

                AnimatorSet as = new AnimatorSet();
                as.play(alpha).before(translationX);// 在执行translationX之前，先执行alpha。
                as.playTogether(translationX, rotation);// translation和rotation一起执行。
                as.start();
            }
        });
    }
}
