package com.lqr.customerview.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeOvalView extends View {
    public PracticeOvalView(Context context) {
        this(context, null);
    }

    public PracticeOvalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawOval(new RectF(20, 150, width-20, 300), paint);

    }
}
