package com.lqr.customerview.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lqr.customerview.R;


public class PracticeClipPathView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public PracticeClipPathView(Context context) {
        this(context, null);
    }

    public PracticeClipPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        Path p1 = new Path();
        p1.addCircle(point1.x + bitmap.getWidth(), point1.y + bitmap.getHeight(), bitmap.getWidth() * 2 / 3, Path.Direction.CW);
        canvas.clipPath(p1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        paint.setStyle(Paint.Style.STROKE);
        canvas.save();
        Path p2 = new Path();
        p2.addArc(new RectF(point2.x + bitmap.getWidth() / 2, point2.y + bitmap.getHeight() / 2, point2.x + bitmap.getWidth() * 3 / 2, point2.y + bitmap.getHeight() * 3 / 2), -90, -90);
        p2.lineTo(point2.x + bitmap.getWidth() / 2, point2.y + bitmap.getHeight());
        p2.lineTo(point2.x, point2.y + bitmap.getHeight());
        p2.lineTo(point2.x, point2.y);
        p2.lineTo(point2.x + bitmap.getWidth(), point2.y);
        p2.lineTo(point2.x + bitmap.getWidth(), point2.y + bitmap.getHeight() / 2);
        canvas.clipPath(p2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
