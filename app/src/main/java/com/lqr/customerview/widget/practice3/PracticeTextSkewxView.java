package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeTextSkewxView extends View {

    public PracticeTextSkewxView(Context context) {
        this(context, null);
    }

    public PracticeTextSkewxView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeTextSkewxView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello CSDN_LQR";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);
        paint.setTextSkewX(-0.2f);
        canvas.drawText(text, 50, 100, paint);

    }
}
