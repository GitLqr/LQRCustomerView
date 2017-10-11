package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeTypefaceView extends View {

    public PracticeTypefaceView(Context context) {
        this(context, null);
    }

    public PracticeTypefaceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeTypefaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);
        String text = "Hello CSDN_LQR";

        int y = 100;
        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText(text, 50, y, paint);

        y += 50;
        paint.setTypeface(Typeface.SERIF);
        canvas.drawText(text, 50, y, paint);

        y += 50;
        paint.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "Satisfy-Regular.ttf"));
        canvas.drawText(text, 50, y, paint);

    }
}
