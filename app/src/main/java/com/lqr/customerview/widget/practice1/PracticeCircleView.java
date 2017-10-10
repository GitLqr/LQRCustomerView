package com.lqr.customerview.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeCircleView extends View {

    private int randius = 150;
    private int interval = 20;
    private int strokeWidth = 15;

    public PracticeCircleView(Context context) {

        this(context, null);
    }

    public PracticeCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();

        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setStyle(Paint.Style.FILL);
        p1.setColor(Color.BLACK);
        canvas.drawCircle(width / 2 - (randius + interval), (randius + interval), randius, p1);

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(2);
        p2.setColor(Color.BLACK);
        canvas.drawCircle(width / 2 + (randius + interval), (randius + interval), randius, p2);

        Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p3.setStyle(Paint.Style.FILL);
        p3.setColor(Color.BLUE);
        canvas.drawCircle(width / 2 - (randius + interval), (3 * randius + 2 * interval), randius, p3);

        Paint p4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p4.setStyle(Paint.Style.STROKE);
        p4.setStrokeWidth(strokeWidth);
        p4.setColor(Color.BLACK);
        canvas.drawCircle(width / 2 + (randius + interval), (3 * randius + 2 * interval), randius, p4);

    }
}
