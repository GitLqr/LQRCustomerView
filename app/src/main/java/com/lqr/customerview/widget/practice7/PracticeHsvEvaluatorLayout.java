package com.lqr.customerview.widget.practice7;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;

public class PracticeHsvEvaluatorLayout extends RelativeLayout {

    PracticeHsvbEvaluatorView hsvEvaluatorView;
    Button animateBtn;

    public PracticeHsvEvaluatorLayout(Context context) {
        super(context);
    }

    public PracticeHsvEvaluatorLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeHsvEvaluatorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        hsvEvaluatorView = findViewById(R.id.hsvEvaluatorView);
        animateBtn = findViewById(R.id.animateBtn);

        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator oa = ObjectAnimator.ofInt(hsvEvaluatorView, "color", 0xffff0000, 0xff00ff00);
                oa.setEvaluator(new HsvEvaluator());
                oa.setDuration(1000);
                oa.start();
            }
        });
    }

    class HsvEvaluator implements TypeEvaluator<Integer> {

        float[] startHsv = new float[3];
        float[] endHsv = new float[3];
        float[] outHsv = new float[3];

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            // 把ARGB转成HSV
            Color.colorToHSV(startValue, startHsv);
            Color.colorToHSV(endValue, endHsv);

            // 计算当前动画完成度（fraction）所对应的颜色值
            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360;
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360;
            }

            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
            if (outHsv[0] > 360) {
                outHsv[0] -= 360;
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360;
            }

            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            // 计算当前动画完成度（fraction）所对应的透明度
            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            // 把HSV转回ARGB返回
            return Color.HSVToColor(alpha, outHsv);
        }
    }
}
