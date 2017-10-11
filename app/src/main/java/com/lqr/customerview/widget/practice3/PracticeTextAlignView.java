package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeTextAlignView extends View {

    public PracticeTextAlignView(Context context) {
        this(context, null);
    }

    public PracticeTextAlignView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeTextAlignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int startX = width/2;
        String text = "Hello CSDN_LQR";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);

        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(text,startX,100,paint);

        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text,startX,200,paint);

        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text,startX,300,paint);
    }
}
