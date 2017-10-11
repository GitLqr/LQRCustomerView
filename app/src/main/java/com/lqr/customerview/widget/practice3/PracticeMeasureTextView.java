package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeMeasureTextView extends View {

    public PracticeMeasureTextView(Context context) {
        this(context, null);
    }

    public PracticeMeasureTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeMeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text1 = "三个月内你胖了";
        String text2 = "4.5";
        String text3 = "公斤";

        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setTextSize(50);
        p1.setColor(Color.BLACK);

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setTextSize(160);
        p2.setColor(Color.RED);

        canvas.drawText(text1, 50, 200, p1);
        canvas.drawText(text2, 50 + p1.measureText(text1), 200, p2);
        canvas.drawText(text3, 50 + p1.measureText(text1) + p2.measureText(text2), 200, p1);

    }
}
