package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeXfermodeView extends View {

    public PracticeXfermodeView(Context context) {
        this(context, null);
    }

    public PracticeXfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeXfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bLogo = BitmapFactory.decodeResource(getResources(), R.mipmap.batman_logo);
        Bitmap bBatman = BitmapFactory.decodeResource(getResources(), R.mipmap.batman);

        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(bLogo, 0, 0, p1);// 目标
        p1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        canvas.drawBitmap(bBatman, 0, 0, p1);// 源
        p1.setXfermode(null);
        canvas.restoreToCount(saved);

        saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(bBatman, 600, 0, p2);
        p2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bLogo, 600, 0, p2);
        p2.setXfermode(null);
        canvas.restoreToCount(saved);

        saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(bLogo, 0, 600, p3);
        p3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(bBatman, 0, 600, p3);
        p3.setXfermode(null);
        canvas.restoreToCount(saved);

    }
}
