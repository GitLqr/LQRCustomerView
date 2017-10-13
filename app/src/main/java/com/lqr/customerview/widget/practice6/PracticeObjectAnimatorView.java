package com.lqr.customerview.widget.practice6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static com.lqr.customerview.utils.Utils.dpToPixel;

public class PracticeObjectAnimatorView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    float radius = dpToPixel(80);
    float progress = 0;
    RectF arcRectF = new RectF();


    public PracticeObjectAnimatorView(Context context) {
        super(context);
    }

    public PracticeObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setTextSize(dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStrokeWidth(dpToPixel(15));
        paint.setStrokeCap(Paint.Cap.ROUND);

        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }
}