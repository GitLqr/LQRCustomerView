package com.lqr.customerview.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;


public class PracticeOnDrawLayoutView extends LinearLayout {

    Pattern pattern = new Pattern();

    {
        // 启用完整的绘制流程
        setWillNotDraw(false);
    }

    public PracticeOnDrawLayoutView(Context context) {
        this(context, null);
    }

    public PracticeOnDrawLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeOnDrawLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pattern.draw(canvas);
    }

    /*------------------ 斑点类 ------------------*/
    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Spot[] spots;

        private Pattern() {
            spots = new Spot[4];
            spots[0] = new Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Spot(0.62f, 0.78f, 0.083f);
        }

        public Pattern(Spot[] spots) {
            this.spots = spots;
        }

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
