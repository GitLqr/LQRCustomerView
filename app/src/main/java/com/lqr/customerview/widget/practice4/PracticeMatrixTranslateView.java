package com.lqr.customerview.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeMatrixTranslateView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Matrix matrix = new Matrix();
    Bitmap bitmap;
    Point p1 = new Point(200, 200);
    Point p2 = new Point(600, 200);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public PracticeMatrixTranslateView(Context context) {
        this(context, null);
    }

    public PracticeMatrixTranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeMatrixTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        matrix.reset();
        matrix.postTranslate(-100, -100);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, p1.x, p1.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.postTranslate(100, 100);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, p2.x, p2.y, paint);
        canvas.restore();

    }
}
