package com.lqr.customerview.widget.practice6;

import android.content.Context;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.lqr.customerview.R;

import static com.lqr.customerview.utils.Utils.dpToPixel;

public class PracticeInterpolatorView extends LinearLayout {

    Spinner spinner;
    Button animateBtn;
    ImageView imageView;

    Interpolator[] interpolators = new Interpolator[13];
    Path interpolatorPath;

    {
        interpolatorPath = new Path();
        interpolatorPath.lineTo(0.25f, 0.25f);
        interpolatorPath.moveTo(0.25f, 1.5f);
        interpolatorPath.lineTo(1, 1);
        interpolators[0] = new AccelerateDecelerateInterpolator();
        interpolators[1] = new LinearInterpolator();
        interpolators[2] = new AccelerateInterpolator();
        interpolators[3] = new DecelerateInterpolator();
        interpolators[4] = new AnticipateInterpolator();
        interpolators[5] = new OvershootInterpolator();
        interpolators[6] = new AnticipateOvershootInterpolator();
        interpolators[7] = new BounceInterpolator();
        interpolators[8] = new CycleInterpolator(0.5f);
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath);
        interpolators[10] = new FastOutLinearInInterpolator();
        interpolators[11] = new FastOutSlowInInterpolator();
        interpolators[12] = new LinearOutSlowInInterpolator();
    }

    public PracticeInterpolatorView(Context context) {
        super(context);
    }

    public PracticeInterpolatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeInterpolatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        spinner = findViewById(R.id.interpolatorSpinner);
        animateBtn = findViewById(R.id.animateBtn);
        imageView = findViewById(R.id.imageView);
        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.animate()
                        .translationX(dpToPixel(150))
                        .setInterpolator(interpolators[spinner.getSelectedItemPosition()])
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                imageView.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView.setTranslationX(0);
                                    }
                                }, 500);
                            }
                        });
            }
        });


    }

}