package com.example.administrator.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Animation mAlphaAnimation;
    Animation mScaleAnimation;
    Animation mRotateAnimation;
    Animation mTranslateAnimation;
    Animation mSetAnimation;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取动画
        mAlphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        mScaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        mRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        mTranslateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        mSetAnimation = AnimationUtils.loadAnimation(this, R.anim.set);

        mTextView = (TextView) findViewById(R.id.id_tv);

        //注册按键
        findViewById(R.id.id_btn_alpha).setOnClickListener(this);
        findViewById(R.id.id_btn_scale).setOnClickListener(this);
        findViewById(R.id.id_btn_rotate).setOnClickListener(this);
        findViewById(R.id.id_btn_translate).setOnClickListener(this);
        findViewById(R.id.id_btn_set).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_alpha:
                mTextView.startAnimation(mAlphaAnimation);
                break;

            case R.id.id_btn_scale:
                mTextView.startAnimation(mScaleAnimation);
                break;

            case R.id.id_btn_rotate:
                mTextView.startAnimation(mRotateAnimation);
                break;

            case R.id.id_btn_translate:
                mTextView.startAnimation(mTranslateAnimation);
                break;

            case R.id.id_btn_set:
                mTextView.startAnimation(mSetAnimation);
                break;
        }
    }
}
