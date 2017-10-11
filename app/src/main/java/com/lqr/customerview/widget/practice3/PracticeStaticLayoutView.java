package com.lqr.customerview.widget.practice3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;


public class PracticeStaticLayoutView extends View {

    public PracticeStaticLayoutView(Context context) {
        this(context, null);
    }

    public PracticeStaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeStaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100);
        StaticLayout sl = new StaticLayout("Hello\nCSDN_LQR", paint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        sl.draw(canvas);
    }
}
