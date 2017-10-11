package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticePathEffectView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path trianglePath = new Path();

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        trianglePath.rLineTo(0, 0);
        trianglePath.rLineTo(40, 0);
        trianglePath.rLineTo(-20, 40);
    }

    public PracticePathEffectView(Context context) {
        this(context, null);
    }

    public PracticePathEffectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticePathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setPathEffect(new CornerPathEffect(5));
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        DiscretePathEffect discretePathEffect = new DiscretePathEffect(20, 5);
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{20, 5, 10, 5}, 5);
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        paint.setPathEffect(new PathDashPathEffect(trianglePath, 35f, 5f, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        paint.setPathEffect(new SumPathEffect(dashPathEffect, discretePathEffect));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        paint.setPathEffect(new ComposePathEffect(dashPathEffect, discretePathEffect));
        canvas.drawPath(path, paint);
        canvas.restore();

    }
}
