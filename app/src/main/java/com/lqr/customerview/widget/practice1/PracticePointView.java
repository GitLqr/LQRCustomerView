package com.lqr.customerview.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticePointView extends View {
    public PracticePointView(Context context) {
        this(context, null);
    }

    public PracticePointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticePointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();

        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setStrokeCap(Paint.Cap.ROUND);
        p1.setColor(Color.BLACK);
        p1.setStrokeWidth(50);
        canvas.drawPoint(width / 4, width / 2, p1);

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setStrokeCap(Paint.Cap.BUTT);
        p2.setColor(Color.BLACK);
        p2.setStrokeWidth(50);
        canvas.drawPoint(width * 3 / 4, width / 2, p2);

    }
}
