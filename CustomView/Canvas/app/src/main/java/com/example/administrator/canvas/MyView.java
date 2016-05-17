package com.example.administrator.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Administrator on 2016/5/16.
 */
public class MyView extends View {

    Context mContext;

    public MyView(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

/**总结
1、每次调用canvas.drawXXXX系列函数来绘图后，都会产生一个全新的Canvas画布。
2、如果在DrawXXX前，调用平移、旋转等函数来对Canvas进行了操作，那么这个操作是不可逆的！每次产生的画布的最新位置都是这些操作后的位置。
3、在Canvas与屏幕合成时，超出屏幕范围的图像是不会显示出来的。*/

/**平移(translate)
        //构造一红一绿两个画笔
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paint_red = generatePaint(Color.RED, Paint.Style.STROKE, 3);
        //构造一个矩形
        Rect rect = new Rect(0, 0, 200, 120);
        //在平移画布前用绿色画下边框
        canvas.drawRect(rect, paint_green);
        //平移画布后再用红色边框重新画下这个矩形
        canvas.translate(50, 50); //向右向下平移50像素
        canvas.drawRect(rect, paint_red); */

/**旋转(Rotate)
        //构造函数
        //void rotate(float degrees) //输入旋转的度数，正数是顺时针旋转，负数指逆时针旋转，旋转中心点是原点（0，0）
        //void rotate (float degrees, float px, float py) //除了度数以外，还可以指定旋转的中心点坐标（px,py）
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.FILL, 3);
        Paint paint_red = generatePaint(Color.RED, Paint.Style.STROKE, 3);
        Rect rect = new Rect(100, 0, 300, 120);
        canvas.drawRect(rect, paint_red); //画出原轮廓
        canvas.rotate(30); //顺时针旋转画布
        canvas.drawRect(rect, paint_green); //画出旋转后的矩形 */

/**缩放(scale)
        //构造函数
        //public void scale (float sx, float sy) //sx/sy: x轴/y轴伸缩比例 <1 缩小 >1 放大
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 3);
        Rect rect = new Rect(0, 0, 200, 120);
        canvas.drawRect(rect, paint_green);
        canvas.scale(0.5f, 1.5f);
        canvas.drawRect(rect, paint_red); */

/**斜切(skew)
        //构造函数
        //void skew (float sx, float sy)  //sx/sy: 将画布在x轴/y轴倾斜相应的角度，sx/sy为倾斜角度的tan值
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paint_red = generatePaint(Color.RED, Paint.Style.STROKE, 3);
        Rect rect = new Rect(0, 0, 200, 120);
        canvas.drawRect(rect, paint_green);
        canvas.skew(1.732f, 0); //x轴倾斜60度
        canvas.drawRect(rect, paint_red); */

/**裁剪画布(clip系列函数)
        //clip系列函数
        //boolean	clipPath(Path path)
        //boolean	clipPath(Path path, Region.Op op)
        //boolean	clipRect(Rect rect, Region.Op op)
        //boolean	clipRect(RectF rect, Region.Op op)
        //boolean	clipRect(int left, int top, int right, int bottom)
        //boolean	clipRect(float left, float top, float right, float bottom)
        //boolean	clipRect(RectF rect)
        //boolean	clipRect(float left, float top, float right, float bottom, Region.Op op)
        //boolean	clipRect(Rect rect)
        //boolean	clipRegion(Region region)
        //boolean	clipRegion(Region region, Region.Op op)
        canvas.drawColor(Color.RED);
        canvas.clipRect(new Rect(50, 50, 200, 120));
        canvas.drawColor(Color.GREEN); */

//画布的保存与恢复(save()、restore())
        //save()：每次调用save()函数，都会把当前的画布的状态进行保存，然后放入特定的栈中
        //restore()：每当调用restore()函数，就会把栈中最顶层的画布状态取出来，并按照这个状态恢复当前的画布，并在这个画布上做画。
        canvas.drawColor(Color.RED);
        //保存当前画布大小即整屏
        canvas.save();
        canvas.clipRect(new Rect(50, 50, 200, 120));
        canvas.drawColor(Color.GREEN);
        //恢复整屏画布
        //canvas.restore();
        //canvas.drawColor(Color.BLUE); //*/
    }

    private Paint generatePaint(int color, Paint.Style style, int width) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
