package com.lqr.customerview.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeRotateView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point p1 = new Point(200, 200);
    Point p2 = new Point(600, 200);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public PracticeRotateView(Context context) {
        this(context, null);
    }

    public PracticeRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(180, p1.x + bitmap.getWidth() / 2, p1.y + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, p1.x, p1.y, paint);
        canvas.restore();


        canvas.save();
        canvas.rotate(45, p2.x + bitmap.getWidth() / 2, p2.y + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, p2.x, p2.y, paint);
        canvas.restore();

    }
}
