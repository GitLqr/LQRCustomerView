package com.lqr.customerview.widget.practice6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lqr.customerview.R;

import static com.lqr.customerview.utils.Utils.dpToPixel;

public class PracticeMultiPropertiesView extends ConstraintLayout {

    Button animateBtn;
    ImageView imageView;
    boolean animated;

    public PracticeMultiPropertiesView(Context context) {
        super(context);
    }

    public PracticeMultiPropertiesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeMultiPropertiesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBtn = findViewById(R.id.animateBtn);
        imageView = findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!animated) {
                    imageView.animate()
                            .translationX(dpToPixel(200))
                            .rotation(360)
                            .scaleX(1)
                            .scaleY(1)
                            .alpha(1);
                } else {
                    imageView.animate()
                            .translationX(0)
                            .rotation(0)
                            .scaleX(0)
                            .scaleY(0)
                            .alpha(0);
                }
                animated = !animated;
            }
        });

    }

}