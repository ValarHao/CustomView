package com.example.administrator.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/20.
 */
public class TopBar extends RelativeLayout {

    private String mLeftText;
    private float mLeftTextSize;
    private Drawable mLeftTextBackground;
    private String mTitleText;
    private float mTitleTextSize;
    private String mRightText;
    private float mRightTextSize;
    private Drawable mRightTextBackground;
    private int mTextColor;
    private Drawable mMainBackground;

    private Button mLeftButton;
    private TextView mTitleView;
    private Button mRightButton;

    private TopBarOnClickListener mListener;

    public interface TopBarOnClickListener {
        void leftClick();
        void rightClick();
    }

    //暴露一个方法给调用者注册接口回调
    public void setTopBarOnClickListener(TopBarOnClickListener listener) {
        mListener = listener;
    }

    public TopBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //获取属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TopBar, defStyle, 0);
        int n = a.getIndexCount();
        for (int i=0; i<n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.TopBar_leftText:
                    mLeftText = a.getString(attr);
                    break;
                case R.styleable.TopBar_leftTextSize:
                    mLeftTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 24, getResources().getDisplayMetrics()
                    ));
                    break;
                case R.styleable.TopBar_leftTextBackground:
                    mLeftTextBackground = a.getDrawable(attr);
                    break;
                case R.styleable.TopBar_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.TopBar_titleTextSize:
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 24, getResources().getDisplayMetrics()
                    ));
                    break;
                case R.styleable.TopBar_rightText:
                    mRightText = a.getString(attr);
                    break;
                case R.styleable.TopBar_rightTextSize:
                    mRightTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 24, getResources().getDisplayMetrics()
                    ));
                    break;
                case R.styleable.TopBar_rightTextBackground:
                    mRightTextBackground = a.getDrawable(attr);
                    break;
                case R.styleable.TopBar_textColor:
                    mTextColor = a.getColor(attr, 0xFFFFFF);
                    break;
                case R.styleable.TopBar_mainBackground:
                    mMainBackground = a.getDrawable(attr);
                    break;
            }
        }
        a.recycle();

        //组合控件
        mLeftButton = new Button(context);
        mTitleView = new TextView(context);
        mRightButton = new Button(context);

        mLeftButton.setText(mLeftText);
        mLeftButton.setTextSize(mLeftTextSize);
        mLeftButton.setBackground(mLeftTextBackground);
        mLeftButton.setTextColor(mTextColor);
        mTitleView.setText(mTitleText);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);
        mTitleView.setTextColor(mTextColor);
        mRightButton.setText(mRightText);
        mRightButton.setTextSize(mRightTextSize);
        mRightButton.setBackground(mRightTextBackground);
        mRightButton.setTextColor(mTextColor);
        this.setBackground(mMainBackground); //设定RelativeLayout背景图

        //给控件设定属性
        LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, leftParams);

        LayoutParams titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, titleParams);

        LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, rightParams);

        //按键监听
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.rightClick();
            }
        });
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context) {
        this(context, null);
    }
}
