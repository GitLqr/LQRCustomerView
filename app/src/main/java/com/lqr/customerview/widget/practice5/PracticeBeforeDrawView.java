package com.lqr.customerview.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


public class PracticeBeforeDrawView extends AppCompatEditText {


    public PracticeBeforeDrawView(Context context) {
        super(context);
    }

    public PracticeBeforeDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeBeforeDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#66BB6A")); // 涂上绿色
        super.onDraw(canvas);
    }
}
