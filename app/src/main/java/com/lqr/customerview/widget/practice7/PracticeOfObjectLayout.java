package com.lqr.customerview.widget.practice7;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lqr.customerview.R;


public class PracticeOfObjectLayout extends RelativeLayout {

    PracticeOfObjectView ofObjectView;
    Button animateBtn;

    public PracticeOfObjectLayout(Context context) {
        super(context);
    }

    public PracticeOfObjectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeOfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ofObjectView = findViewById(R.id.ofObjectView);
        animateBtn = findViewById(R.id.animateBtn);
        animateBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator oa = ObjectAnimator.ofObject(ofObjectView, "position", new PositionEvaluator(), new PointF(0, 0), new PointF(1, 1));
                oa.setDuration(1000);
                oa.setInterpolator(new LinearInterpolator());
                oa.start();
            }
        });
    }

    class PositionEvaluator implements TypeEvaluator<PointF> {

        PointF newPosition = new PointF();

        @Override
        public PointF evaluate(float fraction, PointF startPointF, PointF endPointF) {
            float x = startPointF.x + (endPointF.x - startPointF.x) * fraction;
            float y = startPointF.y + (endPointF.y - startPointF.y) * fraction;
            newPosition.set(x, y);
            return newPosition;
        }
    }
}
