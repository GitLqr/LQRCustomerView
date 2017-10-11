package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeStrokeMiterView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(40);
        path.rLineTo(200, 0);
        path.rLineTo(-160, 120);

    }

    public PracticeStrokeMiterView(Context context) {
        this(context, null);
    }

    public PracticeStrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeStrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        paint.setStrokeMiter(1);
        canvas.translate(100, 100);
        canvas.drawPath(path, paint);
        paint.setStrokeMiter(2);
        canvas.translate(300, 0);
        canvas.drawPath(path, paint);
        paint.setStrokeMiter(5);
        canvas.translate(300, 0);
        canvas.drawPath(path, paint);
        canvas.restore();

    }
}
