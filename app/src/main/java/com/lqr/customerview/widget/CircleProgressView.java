package com.lqr.customerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;

/**
 * @创建者 CSDN_LQR
 * @描述 圆形进度条
 * <p>
 * http://www.jianshu.com/p/be71f6ffe512
 */
public class CircleProgressView extends View {

    private float mCurrent = 0;// 当前进度

    private float mPaintWidth;
    private int mPaintColor = Color.RED;
    private float mTextSize;
    private int mTextColor = Color.BLACK;
    private int mStartAngle = 0;

    private Paint mPaintOut;
    private Paint mPaintProgress;
    private Paint mPaintText;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        mPaintWidth = array.getDimension(R.styleable.CircleProgressView_progress_paint_width, dip2px(context, 4));// 默认4dp
        mPaintColor = array.getColor(R.styleable.CircleProgressView_progress_paint_color, mPaintColor);
        mTextSize = array.getDimension(R.styleable.CircleProgressView_progress_text_size, dip2px(context, 16));// 默认16sp
        mTextColor = array.getColor(R.styleable.CircleProgressView_progress_text_color, mTextColor);
        int progressLocation = array.getInt(R.styleable.CircleProgressView_progress_begin_location, 3);
        array.recycle();

        initStartAngle(progressLocation);
        initPaints();
    }

    private void initStartAngle(int location) {
        switch (location) {
            case 1:// 左
                mStartAngle = -180;
                break;
            case 2:// 上
                mStartAngle = -90;
                break;
            case 3:// 右
                mStartAngle = 0;
                break;
            case 4:// 下
                mStartAngle = 90;
                break;
        }
    }

    private void initPaints() {
        // 画笔：背景圆弧
        mPaintOut = new Paint();
        mPaintOut.setAntiAlias(true);//防止边缘的锯齿
        mPaintOut.setStyle(Paint.Style.STROKE);// 实线
        mPaintOut.setStrokeCap(Paint.Cap.ROUND);//线帽：圆形
        mPaintOut.setStrokeWidth(mPaintWidth);
        mPaintOut.setColor(Color.GRAY);
        // 画笔：进度圆弧
        mPaintProgress = new Paint();
        mPaintProgress.setAntiAlias(true);
        mPaintProgress.setStyle(Paint.Style.STROKE);
        mPaintProgress.setStrokeCap(Paint.Cap.ROUND);
        mPaintProgress.setStrokeWidth(mPaintWidth);
        mPaintProgress.setColor(mPaintColor);
        // 画笔：进度文字
        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setStrokeCap(Paint.Cap.ROUND);
        mPaintText.setTextSize(mTextSize);
        mPaintText.setColor(mTextColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1. 画背景圆弧
        //绘制背景圆弧,因为画笔有一定的宽度，所有画圆弧的范围要比View本身的大小稍微小一些，不然画笔画出来的东西会显示不完整
        RectF rectF = new RectF(mPaintWidth / 2, mPaintWidth / 2, getWidth() - mPaintWidth / 2, getHeight() - mPaintWidth / 2);
        canvas.drawArc(rectF, 0, 360, false, mPaintOut);

        // 2. 画进度圆弧
        //mCurrent/100 = swipeAngle/360  ==> swipeAngle = mCurrent/100*360
        float swipeAngle = mCurrent * 360 / 100;
        canvas.drawArc(rectF, mStartAngle, swipeAngle, false, mPaintProgress);

        // 3. 画进度文字（居中显示）
        String text = mCurrent + " %";
        // 要先计算基点（x,y）
        float x = getWidth() / 2 - mPaintText.measureText(text, 0, text.length()) / 2;// view宽度的一半 - 文字宽度的一半
        Paint.FontMetricsInt fontMetricsInt = mPaintText.getFontMetricsInt();
        float y = getHeight() / 2 + (fontMetricsInt.bottom - fontMetricsInt.top) / 2;// view高度的一半 + 文字高度的一半
        canvas.drawText(text, x, y, mPaintText);

        if (mListener != null) {
            if (mCurrent == 0) {
                mListener.onStart();
            } else if (mCurrent == 100) {
                mListener.onComplete();
            } else {
                mListener.onProgress(mCurrent);
            }
        }
    }

    /**
     * 设置当前进度并重新绘制界面
     */
    public void setCurrent(int current) {
        mCurrent = current;
        invalidate();
    }

    OnProgressListener mListener;

    public void setListener(OnProgressListener listener) {
        mListener = listener;
    }

    public interface OnProgressListener {
        void onStart();

        void onProgress(float progress);

        void onComplete();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
