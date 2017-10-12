package com.lqr.customerview.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


public class PracticeAfterOnDrawView extends android.support.v7.widget.AppCompatImageView {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        paint.setColor(Color.parseColor("#FFC107"));
        paint.setTextSize(28);
    }

    public PracticeAfterOnDrawView(Context context) {
        this(context, null);
    }

    public PracticeAfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeAfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
            canvas.concat(getImageMatrix());
            Rect bounds = drawable.getBounds();
            canvas.drawText("尺寸 " + bounds.width() + " * " + bounds.height(), 20, 40, paint);
            canvas.restore();
        }

    }
}
