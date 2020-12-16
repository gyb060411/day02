package com.example.day02.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P> extends AppCompatActivity {

    private P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (persenter == null) {
            persenter=getPersenter();
        }
        initData();
        initView();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();

    protected abstract P getPersenter();
}
