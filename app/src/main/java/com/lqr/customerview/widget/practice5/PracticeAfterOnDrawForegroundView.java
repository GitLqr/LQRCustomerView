package com.lqr.customerview.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


public class PracticeAfterOnDrawForegroundView extends AppCompatImageView {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        paint.setTextSize(60);
    }

    public PracticeAfterOnDrawForegroundView(Context context) {
        this(context, null);
    }

    public PracticeAfterOnDrawForegroundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeAfterOnDrawForegroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 没有调用onDrawForeground()，原因不明，可以用draw()代替
    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        paint.setColor(Color.parseColor("#f44336"));
        canvas.drawRect(0, 40, 200, 120, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("New", 20, 100, paint);
    }

}
