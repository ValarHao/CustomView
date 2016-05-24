package com.example.administrator.valueanimator;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtn;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.id_btn);
        mTextView = (TextView) findViewById(R.id.id_tv);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAnimation();
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked TextView", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /** ValueAnimation常用方法
     *  ValueAnimator setDuration(long duration) => 设置动画时长，单位是毫秒
     *  Object getAnimatedValue() => 获取ValueAnimator在运动时，当前运动点的值
     *  void start() => 开始动画
     *  void setRepeatCount(int value) => 设置循环次数,设置为INFINITE表示无限循环
     *  void setRepeatMode(int value) => 设置循环模式，取值有RESTART，REVERSE
     *  void cancel() => 取消动画
     *  public void setStartDelay(long startDelay) => 延时多久时间开始，单位是毫秒
     *  public ValueAnimator clone() => 完全克隆一个ValueAnimator实例，包括它所有的设置以及所有对监听器代码的处理
     */

    private void doAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 200); //创建ValueAnimation实例，第1步
        animator.setDuration(1000); //第二步

        // 进行监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                mTextView.layout(curValue, curValue, curValue + mTextView.getWidth(), curValue + mTextView.getHeight());
            }
        });

        animator.start(); //第三步
    }
}
