package com.example.administrator.objectanimator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtn;
    private TextView mTextView;
    private PointView mPointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.id_btn);
        mTextView = (TextView) findViewById(R.id.id_tv);
        mPointView = (PointView) findViewById(R.id.id_point_view);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //doAlpha();
                //doRotation();
                //doRotationX();
                //doRotationY();
                //doTranslationX();
                //doTranslationY();
                //doScaleX();
                //doScaleY();
                doPointView();
            }
        });
    }

    /** public static ObjectAnimator ofFloat(Object target, String propertyName, float... values)
     *  第一个参数用于指定这个动画要操作的是哪个控件
     *  第二个参数用于指定这个动画要操作这个控件的哪个属性
     *  第三个参数是可变长参数，指这个属性值是从哪变到哪
     */

    private void doAlpha() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "alpha", 1, 0, 1);
        animator.setDuration(2000);
        animator.start();
    }

    private void doRotation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "rotation", 0, 180, 0);
        animator.setDuration(2000);
        animator.start();
    }

    /** ObjectAnimator做动画，并不是根据控件xml中的属性来改变的，而是通过指定属性所对应的set方法来改变的
     *  指定"alpha"时会使用View中继承的setAlpha()方法，指定"rotation"时会使用View中继承的setRotation()方法
     *  在View中有关动画，总共有下面几组set方法：
     *  public void setAlpha(float alpha) => 透明度：alpha
     *  public void setRotation(float rotation) => 旋转度数：rotation
     *  public void setRotationX(float rotationX) => 旋转度数：rotationX
     *  public void setRotationY(float rotationY) => 旋转度数：rotationY
     *  public void setTranslationX(float translationX) => 平移：translationX
     *  public void setTranslationY(float translationY) => 平移：translationY
     *  public void setScaleX(float scaleX) => 缩放：scaleX
     *  public void setScaleY(float scaleY) => 缩放：scaleY
     */

    private void doRotationX() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "rotationX", 0, 270, 0);
        animator.setDuration(2000);
        animator.start();
    }

    private void doRotationY() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "rotationY", 0, 180, 0);
        animator.setDuration(2000);
        animator.start();
    }

    private void doTranslationX() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "translationX", 0, 100, -100, 0);
        animator.setDuration(2000);
        animator.start();
    }

    private void doTranslationY() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "translationY", 0, 100, -100, 0);
        animator.setDuration(2000);
        animator.start();
    }

    private void doScaleX() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "scaleX", 0, 3, 1);
        animator.setDuration(2000);
        animator.start();
    }

    private void doScaleY() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTextView, "scaleY", 0, 3, 1);
        animator.setDuration(2000);
        animator.start();
    }

    /** ObjectAnimator的动画设置流程：ObjectAnimator需要指定操作的控件对象
     *  在开始动画时，到控件类中去寻找设置属性所对应的set函数，然后把动画中间值做为参数传给这个set函数并执行它
     *  因此自定义动画的时候得先编写该set方法，字符串参数得与set方法后缀一致（首字母大小写可以不一样）
     */

    private void doPointView() {
        ObjectAnimator animator = ObjectAnimator.ofInt(mPointView, "pointRadius", 0, 300, 100);
        animator.setDuration(2000);
        animator.start();
    }
}
