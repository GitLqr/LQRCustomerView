package com.lqr.customerview.widget.practice2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeComposeShaderView extends View {

    public PracticeComposeShaderView(Context context) {
        this(context, null);
    }

    public PracticeComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        BitmapShader bsBatman = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        BitmapShader bsBatmanLogo = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.batman_logo), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //ComposeShader() 在硬件加速下是不支持两个相同类型的 Shader 的，所以这里也需要关闭硬件加速才能看到效果。
        paint.setShader(new ComposeShader(bsBatman, bsBatmanLogo, PorterDuff.Mode.DST_IN));
        canvas.drawCircle(200, 200, 200, paint);
    }
}
