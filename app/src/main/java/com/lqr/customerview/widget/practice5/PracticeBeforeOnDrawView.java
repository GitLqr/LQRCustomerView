package com.lqr.customerview.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;


public class PracticeBeforeOnDrawView extends AppCompatTextView {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds = new RectF();

    {
        paint.setColor(Color.parseColor("#FFC107"));
    }

    public PracticeBeforeOnDrawView(Context context) {
        this(context, null);
    }

    public PracticeBeforeOnDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeBeforeOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Layout layout = getLayout();

        // 得到第2行文字的矩形区域
        bounds.left = layout.getLineLeft(1);
        bounds.top = layout.getLineTop(1);
        bounds.right = layout.getLineRight(1);
        bounds.bottom = layout.getLineBottom(1);
        canvas.drawRect(bounds, paint);

        // 得到倒数第3行文字的矩形区域
        bounds.left = layout.getLineLeft(layout.getLineCount() - 3);
        bounds.top = layout.getLineTop(layout.getLineCount() - 3);
        bounds.right = layout.getLineRight(layout.getLineCount() - 3);
        bounds.bottom = layout.getLineBottom(layout.getLineCount() - 3);
        canvas.drawRect(bounds, paint);


        super.onDraw(canvas);
    }
}
