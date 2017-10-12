package com.lqr.customerview.widget.practice4;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeFlipboardView extends View {

    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    ValueAnimator va;
    int degree;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
        va = ValueAnimator.ofInt(0, 180);
        va.setDuration(2000);
        va.setRepeatCount(ValueAnimator.INFINITE);
        va.setRepeatMode(ValueAnimator.REVERSE);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                degree = (int) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        va.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        va.end();
    }

    public PracticeFlipboardView(Context context) {
        this(context, null);
    }

    public PracticeFlipboardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeFlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int x = centerX - bitmap.getWidth() / 2;
        int y = centerY - bitmap.getHeight() / 2;

        // 绘制上部分
        canvas.save();
        canvas.clipRect(0, 0, width, centerY);
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

        // 绘制下部分
        canvas.save();
        if (degree < 90) {
            canvas.clipRect(0, centerY, width, height);
        } else {
            canvas.clipRect(0, 0, width, centerY);
        }

        camera.save();
        camera.rotateX(degree);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        canvas.concat(matrix);

        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

    }
}
