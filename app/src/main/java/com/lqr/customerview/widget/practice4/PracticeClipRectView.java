package com.lqr.customerview.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public PracticeClipRectView(Context context) {
        this(context, null);
    }

    public PracticeClipRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;

        canvas.clipRect(left, top + bitmap.getHeight() / 4, left + bitmap.getWidth(), top + bitmap.getHeight() * 3 / 4);
        canvas.drawBitmap(bitmap, left, top, paint);

    }
}
