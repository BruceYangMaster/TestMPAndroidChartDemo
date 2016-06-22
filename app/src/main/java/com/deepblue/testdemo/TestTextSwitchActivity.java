package com.deepblue.testdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TestTextSwitchActivity extends AppCompatActivity {

    private TextSwitcher ts;
    // 索引
    private int index;
    // 文本数组
    private String[] poemArray = {"we", "are", "good", "friends"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_switch);
        ts = (TextSwitcher) findViewById(R.id.textswitch);
//定义视图显示工厂，并设置
        ts.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView tv = new TextView(TestTextSwitchActivity.this);
                tv.setTextSize(32);
                tv.setTextColor(Color.GREEN);
                return tv;
            }
        });
        // 设置图片来源
        ts.setText(poemArray[index]);

        // 设置点击监听器
        ts.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // 点击会切换图片
                index++;
                if (index >= poemArray.length) {
                    index = 0;
                }
                ts.setText(poemArray[index]);
            }
        });

        // 设置切入动画
        ts.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left));
        // 设置切出动画
        ts.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right));
    }
}
