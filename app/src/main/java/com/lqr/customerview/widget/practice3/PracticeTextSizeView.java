package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeTextSizeView extends View {

    public PracticeTextSizeView(Context context) {
        this(context, null);
    }

    public PracticeTextSizeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello CSDN_LQR";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int y = 100;
        paint.setTextSize(16);
        canvas.drawText(text, 50, y, paint);

        y += 30;
        paint.setTextSize(24);
        canvas.drawText(text, 50, y, paint);

        y += 55;
        paint.setTextSize(48);
        canvas.drawText(text, 50, y, paint);

        y += 80;
        paint.setTextSize(72);
        canvas.drawText(text, 50, y, paint);
    }
}
