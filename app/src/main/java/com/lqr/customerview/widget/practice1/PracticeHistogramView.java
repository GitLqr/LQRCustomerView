package com.lqr.customerview.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeHistogramView extends View {

    private int firstInterval = 60; // 第一间隔
    private String[] strArr = {"Feroyo", "GB", "ICS", "JB", "KitKat", "L", "M"};

    public PracticeHistogramView(Context context) {

        this(context, null);
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int lineHeight = width * 2 / 3;
        int lineWidth = width - firstInterval;

        // 画x轴、y轴
        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.GRAY);
        canvas.drawLine(firstInterval, 20, firstInterval, lineHeight, p1);
        canvas.drawLine(firstInterval, lineHeight, lineWidth, lineHeight, p1);

        // 画柱子
        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.GREEN);
        p2.setStyle(Paint.Style.FILL);
        Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setColor(Color.BLACK);
        p3.setTextSize(40);
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        int interval = firstInterval / 3;// 柱子间距
        int widthRect = firstInterval * 2;// 柱子宽度
        for (int i = 0; i < 7; i++) {
            left = interval + right + (i == 0 ? firstInterval : 0);
            top = (int) (lineHeight * Math.random());
            right = left + widthRect;
            bottom = lineHeight;
            canvas.drawRect(new RectF(left, top, right, bottom), p2);
            canvas.drawText(strArr[i], left + widthRect / 2 - p3.measureText(strArr[i]) / 2, lineHeight + 40, p3);
        }
    }
}
