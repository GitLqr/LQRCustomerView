
package com.lqr.customerview.widget.practice7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.utils.Utils;


public class PracticeOfObjectView extends View {

    public static final float RADIUS = Utils.dpToPixel(20);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    PointF position = new PointF();

    {
        paint.setColor(Color.CYAN);
    }

    public PracticeOfObjectView(Context context) {
        super(context);
    }

    public PracticeOfObjectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeOfObjectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PointF getPosition() {
        return position;
    }

    public void setPosition(PointF position) {
        if (this.position != null) {
            this.position.set(position);
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float innerPaddingLeft = RADIUS * 1;
        float innerPaddingTop = RADIUS * 1;
        float innerPaddingRight = RADIUS * 1;
        float innerPaddingBottom = RADIUS * 3;
        float width = getWidth() - innerPaddingLeft - innerPaddingRight - RADIUS * 2;
        float height = getHeight() - innerPaddingTop - innerPaddingBottom - RADIUS * 2;

        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x, innerPaddingLeft + RADIUS + height * position.y, RADIUS, paint);
    }
}
