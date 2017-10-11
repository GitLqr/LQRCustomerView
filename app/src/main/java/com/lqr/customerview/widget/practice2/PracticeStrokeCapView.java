package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeStrokeCapView extends View {

    public PracticeStrokeCapView(Context context) {
        this(context, null);
    }

    public PracticeStrokeCapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeStrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100, 100, 500, 100, paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 200, 500, 200, paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100, 300, 500, 300, paint);
    }
}
