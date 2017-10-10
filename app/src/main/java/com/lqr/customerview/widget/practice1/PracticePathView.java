package com.lqr.customerview.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PracticePathView extends View {

    private int randius = 50;

    public PracticePathView(Context context) {
        this(context, null);
    }

    public PracticePathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticePathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int y1 = 150;

        Path path = new Path();
        path.addArc(new RectF(width / 2 - 2 * randius, y1, width / 2, y1 + 2 * randius), -230, 230);
        path.arcTo(new RectF(width / 2, y1, width / 2 + 2 * randius, y1 + 2 * randius), -180, 230);
        path.lineTo(width / 2, y1 * 2);
        path.close();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);

    }
}
