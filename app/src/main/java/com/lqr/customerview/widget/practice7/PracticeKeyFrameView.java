package com.lqr.customerview.widget.practice7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.utils.Utils;


public class PracticeKeyFrameView extends View {

    private static final float RADIUS = Utils.dpToPixel(80);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int progress = 0;
    RectF arcRectF = new RectF();

    public PracticeKeyFrameView(Context context) {
        super(context);
    }

    public PracticeKeyFrameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeKeyFrameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(Utils.dpToPixel(15));
        paint.setColor(Color.parseColor("#E91E63"));

        arcRectF.set(centerX - RADIUS, centerY - RADIUS, centerX + RADIUS, centerY + RADIUS);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);

        paint.setTextSize(Utils.dpToPixel(40));
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);

    }
}
