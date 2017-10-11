package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeFontSpacingView extends View {

    public PracticeFontSpacingView(Context context) {
        this(context, null);
    }

    public PracticeFontSpacingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello CSDN_LQR";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);

        canvas.drawText(text,50,100,paint);

        canvas.drawText(text,50,100 + paint.getFontSpacing(),paint);

        canvas.drawText(text,50,100 + paint.getFontSpacing()+paint.getFontSpacing(),paint);


    }
}
