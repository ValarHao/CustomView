package com.example.administrator.layouttransaction;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayoutTransitionGroup;
    private int i = 0;
    private LayoutTransition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayoutTransitionGroup = (LinearLayout) findViewById(R.id.id_transition_group);

        findViewById(R.id.id_btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonView();
            }
        });

        findViewById(R.id.id_btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeButtonView();
            }
        });

        /** 自定义Group动画的三个步骤 */
        mTransition = new LayoutTransition(); //第一步，创建实例
        //入场动画:view在这个容器中消失时触发的动画
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f, 0f); //第二步，创建动画并设置
        mTransition.setAnimator(LayoutTransition.APPEARING, animIn);
        //出场动画:view显示时的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        mLayoutTransitionGroup.setLayoutTransition(mTransition); //第三步，将LayoutTransaction设置进ViewGroup
    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        mLayoutTransitionGroup.addView(button, 0);
    }

    private void removeButtonView() {
        if (i > 0) {
            mLayoutTransitionGroup.removeViewAt(0);
            i--;
        }
    }
}
