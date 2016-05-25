package com.example.administrator.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

/**
 * Created by Administrator on 2016/5/14.
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

        // 设置画笔基本属性
        Paint paint = new Paint();
        paint.setAntiAlias(true); //抗锯齿功能
        paint.setColor(Color.RED); //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE); //设置填充样式
        paint.setStrokeWidth(2); //设置画笔宽度
        //paint.setShadowLayer(10, 15, 15, Color.GREEN); //设置阴影

        // 设置画布背景颜色
        canvas.drawRGB(255, 255, 255);

/**----------------------------第一部分：几何图形---------------------------------*/
/**画直线
        canvas.drawLine(100, 100, 200, 200, paint); //根据两点坐标画直线
        float[] pts = {10, 10, 50, 50, 100, 100, 150, 150};
        canvas.drawLines(pts, paint); //根据两个点坐标一组画多条直线 */

/**画点
        canvas.drawPoint(100, 100, paint); //根据点坐标画点
        float[] pts = {10, 10, 50, 50, 100, 100, 150, 150};
        canvas.drawPoints(pts, 2, 4, paint); //根据坐标画多个点，注意这里参数指的是坐标数而不是点的个数，即跳过2个坐标后画4个坐标表示的两个点 */

/**画矩形
        canvas.drawRect(10, 10, 100, 100, paint); //根据四点直接构造画矩形
        RectF rectF = new RectF(120, 10, 210, 100);
        canvas.drawRect(rectF, paint); //使用RectF构造
        Rect rect = new Rect(230, 10, 320, 100);
        canvas.drawRect(rect, paint); //使用Rect构造 */

/**画圆角矩形
        RectF rectF = new RectF(100, 10, 300, 100);
        canvas.drawRoundRect(rectF, 20, 10, paint); //使用RectF构造X轴半径为20，Y轴半径为10的圆角矩形 */

/**画圆
        canvas.drawCircle(150, 150, 100, paint); //根据圆心和半径画圆 */

/**画椭圆
        RectF rectF = new RectF(100, 10, 300, 100);
        canvas.drawRect(rectF, paint); //画矩形
        paint.setColor(Color.GREEN); //更改画笔颜色
        canvas.drawOval(rectF, paint); //同一个矩形画椭圆 */

/**画弧
        RectF rectF = new RectF(100, 10, 300, 100);
        canvas.drawArc(rectF, 0, 90, false, paint); //根据矩形画弧 */

/**----------------------------第二部分：路径---------------------------------*/
/**直线路径
        Path path = new Path();
        path.moveTo(10, 10); //设定起始点
        path.lineTo(10, 100); //第一条直线的终点，也是第二条直线的起点
        path.lineTo(100, 100); //画第二条直线
        path.lineTo(300, 100); //画第三条直线
        path.close(); //闭环
        canvas.drawPath(path, paint); */

/**矩形路径
        //先创建两个大小一样的路径
        //第一个逆向生成
        Path CCWRectpath = new Path();
        RectF rectF1 = new RectF(50, 50, 240, 200);
        CCWRectpath.addRect(rectF1, Path.Direction.CCW);
        //第二个顺向生成
        Path CWRectpath = new Path();
        RectF rectF2 = new RectF(290, 50, 480, 200);
        CWRectpath.addRect(rectF2, Path.Direction.CW);
        //画出这两个路径
        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);
        //根据路径写出文字
        String text = "风萧萧兮易水寒，壮士一去不复返";
        paint.setColor(Color.GRAY);
        paint.setTextSize(35);
        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, paint);
        canvas.drawTextOnPath(text, CWRectpath, 0, 18, paint); */

/**圆角矩形路径
        //圆角横轴半径10，圆角纵轴半径15
        Path path = new Path();
        RectF rectF1 = new RectF(50, 50, 240, 200);
        path.addRoundRect(rectF1, 10, 15, Path.Direction.CCW);
        //每个圆角不一样
        RectF rectF2 = new RectF(290, 50, 480, 200);
        float[] radii = {10, 15, 20, 25, 30, 35, 40, 45};
        path.addRoundRect(rectF2, radii, Path.Direction.CCW);
        //画出路径
        canvas.drawPath(path, paint); */

/**圆形路径
        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CCW);
        canvas.drawPath(path, paint); */

/**椭圆路径
        Path path = new Path();
        RectF rectF = new RectF(50, 50, 240, 200);
        path.addOval(rectF, Path.Direction.CCW);
        canvas.drawPath(path, paint); */

/**弧形路径
        Path path = new Path();
        RectF rectF = new RectF(50, 50, 240, 200);
        path.addArc(rectF, 0, 100);
        canvas.drawPath(path, paint); */

/**----------------------------第三部分：区域---------------------------------*/
/**基本构造方法
        public Region()  //创建一个空的区域
        public Region(Region region) //拷贝一个region的范围
        public Region(Rect rect)  //创建一个矩形的区域
        public Region(int left, int top, int right, int bottom) //创建一个矩形的区域 */
/**间接构造
        SetEmpty() //从某种意义上讲置空也是一个构造函数，即将原来的一个区域变量变成了一个空变量，要再利用其它的Set方法重新构造区域。
        set(Region region) //利用新的区域值来替换原来的区域
        set(Rect rect) //利用矩形所代表的区域替换原来的区域
        set(int left, int top, int right, int bottom) //根据矩形的两个点构造出矩形区域来替换原来的区域值
        setPath(Path path, Region clip) //根据路径的区域与某区域的交集，构造出新区域 */

/**set(int left, int top, int right, int bottom)构造矩形
        Region region = new Region(10, 10, 100, 100);
        region.set(100, 100, 200, 200);
        drawRegion(canvas, region, paint); */

/**setPath(Path path, Region clip)构造不规则区域
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rectF = new RectF(50, 50, 200, 500);
        ovalPath.addOval(rectF, Path.Direction.CCW);
        //SetPatch时，传入一个比椭圆区域小的矩形区域，让其取交集
        Region region = new Region();
        region.setPath(ovalPath, new Region(50, 50, 200, 200));
        //画出路径
        drawRegion(canvas, region, paint); */

//区域的合并、交叉等操作
        //构造两个矩形
        Rect rect1 = new Rect(100, 100, 400, 200); //横着的矩形
        Rect rect2 = new Rect(200, 0, 300, 300); //竖着的矩形
        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);
        //构造两个Region
        Region region = new Region(rect1);
        Region region2 = new Region(rect2);
        //取两个区域的交集
        //region.op(region2, Region.Op.INTERSECT); //交集
        //region.op(region2, Region.Op.DIFFERENCE); //补集
        //region.op(region2, Region.Op.REPLACE); //替换
        //region.op(region2, Region.Op.REVERSE_DIFFERENCE); //反转补集
        region.op(region2, Region.Op.UNION); //并集
        //region.op(region2, Region.Op.XOR); //异并集
        //构造一个填充画笔，将所选区域用绿色填充起来
        Paint paint_fill = new Paint();
        paint_fill.setColor(Color.GREEN);
        paint_fill.setStyle(Paint.Style.FILL);
        drawRegion(canvas, region, paint_fill); //*/

/**Region的其他一些方法
        //几个判断方法
        public native boolean isEmpty() //判断该区域是否为空
        public native boolean isRect() //是否是一个矩阵
        public native boolean isComplex() //是否是多个矩阵组合

        //一系列的getBound方法，返回一个Region的边界
        public Rect getBounds()
        public boolean getBounds(Rect r)
        public Path getBoundaryPath()
        public boolean getBoundaryPath(Path path)

        //一系列的判断是否包含某点 和是否相交
        public native boolean contains(int x, int y) //是否包含某点
        public boolean quickContains(Rect r)   //是否包含某矩形
        public native boolean quickContains(int left, int top, int right, int bottom) //是否没有包含某矩阵形
        public boolean quickReject(Rect r) //是否没和该矩形相交
        public native boolean quickReject(int left, int top, int right, int bottom) //是否没和该矩形相交
        public native boolean quickReject(Region rgn)  //是否没和该矩形相交

        //几个平移变换的方法
        public void translate(int dx, int dy)
        public native void translate(int dx, int dy, Region dst)
        public void scale(float scale) //hide
        public native void scale(float scale, Region dst) //hide */
    }

    private void drawRegion(Canvas canvas, Region region, Paint paint) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }
}

