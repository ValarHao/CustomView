package com.example.administrator.topbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.id_tv);
        TopBar topBar = (TopBar) findViewById(R.id.id_top_bar);
        topBar.setTopBarOnClickListener(new TopBar.TopBarOnClickListener() {

            @Override
            public void leftClick() {
                tv.setText("你点击了返回！");
            }

            @Override
            public void rightClick() {
                tv.setText("你点击了编辑！");
            }
        });
    }
}
