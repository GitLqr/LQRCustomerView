package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeFillPathView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();

    {
        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        pathPaint.setStyle(Paint.Style.STROKE);

    }

    public PracticeFillPathView(Context context) {
        this(context, null);
    }

    public PracticeFillPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeFillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0);

        /*------------------ 1 ------------------*/
        paint.getFillPath(path, path1);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        canvas.drawPath(path1, pathPaint);
        canvas.restore();

        /*------------------ 2 ------------------*/
        canvas.save();
        canvas.translate(0, 200);
        paint.setStyle(Paint.Style.STROKE);
        paint.getFillPath(path, path2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        canvas.drawPath(path2, pathPaint);
        canvas.restore();

        /*------------------ 3 ------------------*/
        canvas.save();
        canvas.translate(0, 400);
        paint.setStrokeWidth(40);
        paint.getFillPath(path, path3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        canvas.drawPath(path3, pathPaint);
        canvas.restore();


    }
}
