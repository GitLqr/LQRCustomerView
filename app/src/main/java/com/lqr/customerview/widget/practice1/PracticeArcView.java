package com.lqr.customerview.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeArcView extends View {
    public PracticeArcView(Context context) {
        this(context, null);
    }

    public PracticeArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(200, 150, getWidth() - 200, 550);
//        RectF rectF = new RectF(200, 100, 800, 500);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawArc(rectF, -180, 60, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -110, 110, true, paint);
        canvas.drawArc(rectF, 20, 140, false, paint);

    }
}
