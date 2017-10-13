package com.lqr.customerview.widget.practice7;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;


public class PracticePropertyValuesHolderLayout extends RelativeLayout {

    ImageView imageView;
    Button animateBtn;

    public PracticePropertyValuesHolderLayout(Context context) {
        super(context);
    }

    public PracticePropertyValuesHolderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticePropertyValuesHolderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
                PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0, 1);
                PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
                PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
                PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("rotation", 0, 360);
                ObjectAnimator.ofPropertyValuesHolder(imageView, alpha, scaleX, scaleY, rotation).setDuration(500).start();
            }
        });
    }
}
