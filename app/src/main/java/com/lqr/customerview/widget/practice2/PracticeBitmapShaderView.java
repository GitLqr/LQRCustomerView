package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeBitmapShaderView extends View {

    public PracticeBitmapShaderView(Context context) {
        this(context, null);
    }

    public PracticeBitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeBitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawCircle(200, 200, 200, paint);

    }
}
