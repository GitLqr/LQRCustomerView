package com.lqr.customerview.widget.practice4;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.lqr.customerview.R;


public class PracticeCameraRotateHittingFaceView extends View {

    Matrix matrix = new Matrix();
    Camera camera = new Camera();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point p1 = new Point(200, 200);
    int rotate = 0;
    private ValueAnimator mVa;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 2, bitmap.getHeight() * 2, true);
        bitmap.recycle();
        bitmap = scaledBitmap;

        mVa = ValueAnimator.ofInt(0, 360);
        mVa.setDuration(5000);
        mVa.setRepeatCount(ValueAnimator.INFINITE);
        mVa.setRepeatMode(ValueAnimator.RESTART);
        mVa.setInterpolator(new LinearInterpolator());
        mVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rotate = (int) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mVa.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVa.end();
    }

    public PracticeCameraRotateHittingFaceView(Context context) {
        this(context, null);
    }

    public PracticeCameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeCameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*------------------ 不使用Matrix ------------------*/
//        canvas.save();
//        camera.save();
//        canvas.translate((p1.x + bitmap.getWidth() / 2), (p1.y + bitmap.getHeight() / 2));
//        camera.rotateX(rotate);
//        camera.setLocation(0, 0, -12);
//        camera.applyToCanvas(canvas);
//        canvas.translate(-(p1.x + bitmap.getWidth() / 2), -(p1.y + bitmap.getHeight() / 2));
//        canvas.drawBitmap(bitmap, p1.x, p1.y, paint);
//        camera.restore();
//        canvas.restore();

        /*------------------ 使用Matrix ------------------*/
        int centerX = p1.x + bitmap.getWidth() / 2;
        int centerY = p1.y + bitmap.getHeight() / 2;

        camera.save();
        matrix.reset();
        camera.rotateX(rotate);
        camera.setLocation(0, 0, -12);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerX);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, p1.x, p1.y, paint);
        canvas.restore();
    }
}
