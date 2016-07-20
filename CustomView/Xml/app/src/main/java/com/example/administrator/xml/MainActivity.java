package com.example.administrator.xml;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtn;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.id_btn);
        mTv1 = (TextView) findViewById(R.id.id_tv1);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //valueAnimator();
                //objectAnimator();
                set();
            }
        });
    }

    private void valueAnimator() {
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int offset = (int) valueAnimator.getAnimatedValue();
                mTv1.layout(offset, offset, mTv1.getWidth() + offset, mTv1.getHeight() + offset);
            }
        });
        animator.start();
    }

    private void objectAnimator() {
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.object_animator);
        animator.setTarget(mTv1);
        animator.start();
    }

    private void set() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.set_animator);
        set.setTarget(mTv1);
        set.start();
    }
}
