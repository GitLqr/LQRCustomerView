package com.lqr.customerview.widget.practice0;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @创建者 CSDN_LQR
 * @描述 自定义View_仿PostMan加载效果
 * <p>
 * http://www.jianshu.com/p/c1e17e52e113
 */
public class PostManLoadingView extends View {

    private Paint mPaintPoint;
    private Paint mPaintCircle;
    private int mRandius = 40;
    private int mInterval = 50;//空心圆之间的距离

    private float mX1 = 0;
    private float mY1 = 0;
    private float mX2 = 0;
    private float mY2 = 0;
    private float mX3 = 0;
    private float mY3 = 0;

    public PostManLoadingView(Context context) {
        this(context, null);
    }

    public PostManLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PostManLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 初始化轨迹线、圆点画笔
        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setColor(Color.RED);
        mPaintCircle.setStrokeWidth(3);

        mPaintPoint = new Paint();
        mPaintPoint.setAntiAlias(true);
        mPaintPoint.setStyle(Paint.Style.FILL);
        mPaintPoint.setColor(Color.RED);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 设置该view宽高一致（正方形）
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        // 画中心圆
        canvas.drawCircle(centerX, centerY, mRandius, mPaintPoint);
        // 画3条轨迹线
        canvas.drawCircle(centerX, centerX, mRandius + mInterval, mPaintCircle);
        canvas.drawCircle(centerX, centerX, mRandius + mInterval + mInterval, mPaintCircle);
        canvas.drawCircle(centerX, centerX, mRandius + mInterval + mInterval + mInterval, mPaintCircle);

        // 画3个轨迹球
        canvas.drawCircle(centerX + mX1, centerX + mY1, mRandius, mPaintPoint);
        canvas.drawCircle(centerX + mX2, centerX + mY2, mRandius, mPaintPoint);
        canvas.drawCircle(centerX + mX3, centerX + mY3, mRandius, mPaintPoint);
    }

    public void start() {
        final ValueAnimator va1 = getValueAnimator(mRandius + mInterval);
        va1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float deg = (float) valueAnimator.getAnimatedValue();// 角度
                double rad = Math.toRadians(deg);// 换算成弧度
                mX1 = (float) (Math.cos(rad) * (mRandius + mInterval));
                mY1 = (float) (Math.sin(rad) * (mRandius + mInterval));
                invalidate();
            }
        });
        va1.start();

        ValueAnimator va2 = getValueAnimator(mRandius + mInterval + mInterval);
        va2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float deg = (float) valueAnimator.getAnimatedValue();
                double rad = Math.toRadians(deg);
                mX2 = (float) (Math.cos(rad) * (mRandius + mInterval + mInterval));
                mY2 = (float) (Math.sin(rad) * (mRandius + mInterval + mInterval));
                invalidate();
            }
        });
        va2.start();

        ValueAnimator va3 = getValueAnimator(mRandius + mInterval + mInterval + mInterval);
        va3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float deg = (float) valueAnimator.getAnimatedValue();
                double rad = Math.toRadians(deg);
                mX3 = (float) (Math.cos(rad) * (mRandius + mInterval + mInterval + mInterval));
                mY3 = (float) (Math.sin(rad) * (mRandius + mInterval + mInterval + mInterval));
                invalidate();
            }
        });
        va3.start();
    }

    @NonNull
    private ValueAnimator getValueAnimator(long duration) {
        ValueAnimator va = ValueAnimator.ofFloat(0, 360);
        va.setDuration(duration * 30);// 动画时间随便写
        // 无限循环
        va.setRepeatCount(ValueAnimator.INFINITE);
        va.setRepeatMode(ValueAnimator.RESTART);
        va.setInterpolator(new LinearInterpolator());
        return va;
    }
}
