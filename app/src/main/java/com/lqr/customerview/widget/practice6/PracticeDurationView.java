package com.lqr.customerview.widget.practice6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lqr.customerview.R;

import static com.lqr.customerview.utils.Utils.dpToPixel;

public class PracticeDurationView extends LinearLayout {

    SeekBar durationSb;
    TextView durationValueTv;
    Button animateBtn;
    ImageView imageView;

    int duration = 300;
    int translationState = 0;

    public PracticeDurationView(Context context) {
        super(context);
    }

    public PracticeDurationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeDurationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        durationSb = findViewById(R.id.durationSb);
        durationValueTv = findViewById(R.id.durationValueTv);
        durationValueTv.setText(duration + "ms");
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                durationValueTv.setText(duration + "ms");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        animateBtn = findViewById(R.id.animateBtn);
        imageView = findViewById(R.id.imageView);
        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(dpToPixel(100)).setDuration(duration);
                        break;
                    case 1:
                        imageView.animate().translationX(0).setDuration(duration);
                        break;
                }

                if (translationState < 1) {
                    translationState++;
                } else {
                    translationState = 0;
                }
            }
        });
    }

}