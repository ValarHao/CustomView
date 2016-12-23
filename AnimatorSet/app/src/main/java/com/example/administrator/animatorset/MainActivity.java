package com.example.administrator.animatorset;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStart, mBtnCancel;
    private TextView mTv1, mTv2;
    private AnimatorSet mAnimatorSet;
    private String tag = "Listener";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = (Button) findViewById(R.id.id_btn_start);
        mBtnCancel = (Button) findViewById(R.id.id_btn_cancel);
        mTv1 = (TextView) findViewById(R.id.id_tv1);
        mTv2 = (TextView) findViewById(R.id.id_tv2);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //doPlaySequentially();
                //doPlayTogether();
                //doPlay();
                //doPlayBuilder();
                mAnimatorSet = doListener();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnimatorSet != null) {
                    mAnimatorSet.cancel();
                }
            }
        });
    }

    /** 依次播放动画 */
    private void doPlaySequentially() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    /** 一起播放动画 */
    private void doPlayTogether() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void doPlay() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);

        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);
        tv1TranslateY.setStartDelay(2000); // 延迟2000ms开始
        tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE); // 无限循环

        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator, tv1TranslateY, tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    /** AnimatorSet.Builder => 自由设置动画顺序
     *  Builder常用方法：
     *  public Builder with(Animator anim) => 和前面动画一起执行
     *  public Builder before(Animator anim) => 先执行这个动画再执行前面动画
     *  public Builder after(Animator anim) => 执行前面的动画后才执行该动画
     *  public Builder after(long delay) => 延迟n毫秒之后执行动画
     */
    private void doPlayBuilder() {
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(tv1TranslateY); //调用play()方法生成一个builder对象
        builder.with(tv2TranslateY); //调用with()方法使两个控件一起动作
        animatorSet.start();
    }

    private AnimatorSet doListener() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTv1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 300, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv1TranslateY).with(tv2TranslateY).after(tv1BgAnimator);

        // 添加listener
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.d(tag, "animator start");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.d(tag, "animator end");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.d(tag, "animator cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.d(tag, "animator repeat");
            }
        });

        animatorSet.setDuration(2000);
        animatorSet.start();
        return animatorSet;
    }
}
