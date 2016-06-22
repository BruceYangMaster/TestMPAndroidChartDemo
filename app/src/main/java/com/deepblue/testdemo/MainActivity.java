package com.deepblue.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.deepblue.testdemo.chartview.PieActivity;
import com.deepblue.testdemo.chartview.RadarChartActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
    }

    private void initWidget() {
        /**
         * 垂直滚动的tv
         */
        findViewById(R.id.scroll_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollTvActivity.class));
            }
        });
        /**
         * 垂直滚动的tv
         */
        findViewById(R.id.test_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestTextSwitchActivity.class));
            }
        });

        findViewById(R.id.test_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomViewTestActivity.class));
            }
        });
        findViewById(R.id.test_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RadarChartActivity.class));
            }
        });
        findViewById(R.id.test_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PieActivity.class));
            }
        });
    }
}
