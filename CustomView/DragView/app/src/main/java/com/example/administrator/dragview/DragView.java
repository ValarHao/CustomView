package com.example.administrator.dragview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 常用的实现滑动的四种方法
 */
public class DragView extends View {

    Context mContext;

    int lastX = 0;
    int lastY = 0;

    public DragView(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true); //抗锯齿功能
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE); //填充样式 -> 描边且填充
        paint.setStrokeWidth(2); //画笔宽度
        Rect rect = new Rect(0, 0, 100, 100);
        canvas.drawRect(rect, paint);
    }

    /**
     * 一、layout方法：1.视图相对坐标
     * @param event
     * @return
     */
    /**@Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点的坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //在当前left top right bottom的基础上加上偏移量
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
        }
        return true;
    }*/

    /**
     * 一、layout方法：2.绝对坐标
     * @param event
     * @return
     */
    /**@Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点的坐标
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                //在当前left top right bottom的基础上加上偏移量
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                //重新设置初始坐标
                lastX = rawX;
                lastY = rawY;
                break;
        }
        return true;
    }*/

    /**
     * 二、offsetLeftAndRight()与offsetTopAndBottom()
     * @param event
     * @return
     */
    /**@Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点的坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //区别主要在这里，通过偏移量直接偏移
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }*/

    /**
     * 三、LayoutParams
     */
    /**@Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点的坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //区别主要在这里，通过LayoutParams
                //LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;
        }
        return true;
    }*/

    /**
     * 四、scrollTo与scrollBy
     */
    /**@Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点的坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //区别主要在这里，通过scrollBy
                ((View)getParent()).scrollBy( -offsetX, -offsetY );
                break;
        }
        return true;
    }*/
}
