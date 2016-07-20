package com.example.administrator.randomtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 自定义View的步骤：
 * 1.attrs.xml中自定义View的属性
 * 2.在View的构造方法中获得自定义属性
 * 3.重写onMesure() => 这一步不一定是必须的，根据实际需要选择是否重写
 * 4.重写onDraw()
 */
public class RandomTextView extends View {

    private String mRandomText;
    private int mRandomTextColor;
    private int mRandomTextSize;

    private Rect mBound;
    private Paint mPaint;

    public RandomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        //获得自定义属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RandomTextView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i=0; i<n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.RandomTextView_randomText:
                    mRandomText = a.getString(attr);
                    break;

                case R.styleable.RandomTextView_randomTextColor:
                    //默认颜色设置为黑色
                    mRandomTextColor = a.getColor(attr, Color.BLACK);
                    break;

                case R.styleable.RandomTextView_randomTextSize:
                    //默认设置为16sp，TypeValue也可以把sp转化为px
                    mRandomTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()
                    ));
                    break;
            }
        }

        //回收TypedArray的资源
        a.recycle();

        //获得绘制文本的宽和高
        mPaint = new Paint();
        mPaint.setTextSize(mRandomTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mRandomText, 0, mRandomText.length(), mBound);

        /**
         * 点击生成新随机数
         */
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mRandomText = randomText();
                postInvalidate();
            }
        });
    }

    public RandomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RandomTextView(Context context) {
        this(context, null);
    }

    /**
     * MeasureSpec有三种类型：
     * EXACTLY => 一般是设置了明确的值或者是MATCH_PARENT
     * AT_MOST => 表示子布局限制在一个最大值内，一般为WARP_CONTENT
     * UNSPECIFIED => 表示子布局想要多大就多大，很少使用
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = 0;
        int height = 0;

        /**
         * 设置宽度
         */
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY: //明确指定了尺寸
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;
            case MeasureSpec.AT_MOST: //一般为wrap_content
                width = getPaddingLeft() + getPaddingRight() + mBound.width();
                break;
        }

        /**
         * 设置高度
         */
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY: //明确指定了尺寸
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;
            case MeasureSpec.AT_MOST: //一般为wrap_content
                height = getPaddingTop() + getPaddingBottom() + mBound.height();
                break;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mRandomTextColor);
        canvas.drawText(mRandomText, getWidth()/2 - mBound.width()/2, getHeight()/2 + mBound.height()/2, mPaint);
    }

    /**
     * 产生随机数
     * @return
     */
    private String randomText() {

        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer i : set) {
            stringBuffer.append("" + i);
        }
        return stringBuffer.toString();
    }
}
