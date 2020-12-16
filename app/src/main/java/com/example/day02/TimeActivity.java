package com.example.day02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day02.view.LoginActivity;

public class TimeActivity extends AppCompatActivity {

    private TextView tv;
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            tv.setText("倒计时："+count+"秒");
            if (count==0){
                startActivity(new Intent(TimeActivity.this, LoginActivity.class));
                finish();
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        initView();
    }
    int count=3;
    private void initView() {
        tv = findViewById(R.id.tv);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count>0){
                    try {
                        Thread.sleep(1000);
                        count--;
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}