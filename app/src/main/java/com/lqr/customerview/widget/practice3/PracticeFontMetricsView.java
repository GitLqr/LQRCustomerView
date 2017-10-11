package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeFontMetricsView extends View {

    public PracticeFontMetricsView(Context context) {
        this(context, null);
    }

    public PracticeFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Aa Jj Ââ";

        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setTextSize(160);
        canvas.drawText(text, 50, 200, p1);

        Paint.FontMetrics fontMetrics = p1.getFontMetrics();

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(8);
        p2.setColor(Color.RED);
        canvas.drawRect(50, 200 + fontMetrics.ascent, 50 + p1.measureText(text), 200 + fontMetrics.descent, p2);

    }
}
