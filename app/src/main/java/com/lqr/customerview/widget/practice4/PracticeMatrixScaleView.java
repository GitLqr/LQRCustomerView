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


public class PracticeMatrixScaleView extends View {

    Matrix matrix = new Matrix();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point p1 = new Point(200, 200);
    Point p2 = new Point(600, 200);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public PracticeMatrixScaleView(Context context) {
        this(context, null);
    }

    public PracticeMatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeMatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        matrix.reset();
        matrix.postScale(1.2f, 1.2f, p1.x + bitmap.getWidth() / 2, p1.y + bitmap.getHeight() / 2);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, p1.x, p1.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.postScale(0.5f, 1.5f, p2.x + bitmap.getWidth() / 2, p2.y + bitmap.getHeight() / 2);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, p2.x, p2.y, paint);
        canvas.restore();

    }
}
