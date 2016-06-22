package com.deepblue.testdemo;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ScrollTvActivity extends AppCompatActivity {

    private ScrollTextView scrollTextView;
    private static int count = 0;
    private boolean isContinue;
    private Thread myThread;
    private ArrayList<String> advertList = getList();

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    scrollTextView.next();
                    count++;
                    scrollTextView.setText(advertList.get(count % advertList.size()));
                    break;
                default:
                    break;
            }
        }
    };

    private ArrayList<String> getList() {
        ArrayList<String> advertList = new ArrayList<>();
        advertList.add("的方式改好了的返回结果回家的的风格高科技的农行付款撒娇合肥");
        advertList.add("发撒的发生");
        advertList.add("合格洛克的三个");
        advertList.add("上来发；闪开");
        return advertList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tv);
        init();
    }

    private void init() {

        scrollTextView = (ScrollTextView) findViewById(R.id.switcher02);
        scrollTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) scrollTextView.getCurrentView();
                Toast.makeText(ScrollTvActivity.this, tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        isContinue = true;
        myThread = new Thread() {
            public void run() {
                while (isContinue) {
                    SystemClock.sleep(1000);
                    handler.sendEmptyMessage(0);// 每隔一秒 发一个空消息 滚动一次
                }
            }
        };
        myThread.start();
    }

    /**
     * 在销毁的时候干掉线程
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isContinue = false;
        if (myThread != null && myThread.isAlive()) {
            myThread.interrupt();
        }
    }
}
