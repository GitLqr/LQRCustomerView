package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeTextPathView extends View {

    public PracticeTextPathView(Context context) {
        this(context, null);
    }

    public PracticeTextPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeTextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello CSDN_LQR";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(120);

        Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();

        canvas.drawText(text, 50, 200, paint);

        paint.getTextPath(text, 0, text.length() - 1, 50, 400, path);
        canvas.drawPath(path, pathPaint);

    }
}
