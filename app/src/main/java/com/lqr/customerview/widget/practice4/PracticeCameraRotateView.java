package com.lqr.customerview.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeCameraRotateView extends View {

    Camera camera = new Camera();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point p1 = new Point(200, 200);
    Point p2 = new Point(600, 200);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public PracticeCameraRotateView(Context context) {
        this(context, null);
    }

    public PracticeCameraRotateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeCameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        camera.save();
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap, p1.x, p1.y, paint);
        camera.restore();
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateY(30);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap, p2.x, p2.y, paint);
        camera.restore();
        canvas.restore();

    }
}
