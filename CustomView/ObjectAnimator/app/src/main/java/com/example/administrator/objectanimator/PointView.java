package com.example.administrator.objectanimator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/23.
 */
public class PointView extends View {
    private Point mPoint = new Point(100);

    public PointView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPoint != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300, 300, mPoint.getRadius(), paint);
        }
        super.onDraw(canvas);
    }

    void setPointRadius(int radius) {
        mPoint.setRadius(radius);
        invalidate();
    }
}
