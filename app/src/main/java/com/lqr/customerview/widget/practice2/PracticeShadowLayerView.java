package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticeShadowLayerView extends View {

    public PracticeShadowLayerView(Context context) {
        this(context, null);
    }

    public PracticeShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100);
        paint.setColor(Color.BLACK);
        paint.setShadowLayer(10, 0, 0, Color.RED);

        canvas.drawText("Hello CSDN_LQR",100,400,paint);


    }
}
