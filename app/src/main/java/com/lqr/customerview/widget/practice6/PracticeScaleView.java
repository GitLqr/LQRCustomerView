package com.lqr.customerview.widget.practice6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;

public class PracticeScaleView extends RelativeLayout {

    Button animateBtn;
    ImageView imageView;
    int state = 0;

    public PracticeScaleView(Context context) {
        super(context);
    }

    public PracticeScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBtn = findViewById(R.id.animateBtn);
        imageView = findViewById(R.id.imageView);
        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (state) {
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1);
                        break;
                    case 2:
                        imageView.animate().scaleY(1.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1);
                        break;
                }
                state++;
                if (state == 4) {
                    state = 0;
                }
            }
        });

    }

}