package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeLightingColorFilterView extends View {

    public PracticeLightingColorFilterView(Context context) {
        this(context, null);
    }

    public PracticeLightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeLightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.batman);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new LightingColorFilter(0xffffff, 0x000055));// 增强蓝色
        canvas.drawBitmap(bitmap, 0, 0, paint);
        paint.setColorFilter(new LightingColorFilter(0xffffff, 0x005500));// 增强绿色
        canvas.drawBitmap(bitmap, 600, 0, paint);

    }
}
