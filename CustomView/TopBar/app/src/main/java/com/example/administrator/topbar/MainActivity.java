package com.example.administrator.topbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBar topBar = (TopBar) findViewById(R.id.id_top_bar);
        topBar.setTopBarOnClickListener(new TopBar.TopBarOnClickListener() {

            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "你点击了返回", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "你点击了编辑", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
