package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeTextBoundsView extends View {

    public PracticeTextBoundsView(Context context) {
        this(context, null);
    }

    public PracticeTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Aa Jj Ââ";

        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setTextSize(160);
        canvas.drawText(text, 50, 200, p1);

        Rect rect = new Rect();
        p1.getTextBounds(text, 0, text.length(), rect);
//        rect.set(rect.left + 50, rect.top + 200, rect.right + 50, rect.bottom + 200);
        rect.left += 50;
        rect.top += 200;
        rect.right += 50;
        rect.bottom += 200;

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(8);
        p2.setColor(Color.RED);
        canvas.drawRect(rect, p2);

    }
}
