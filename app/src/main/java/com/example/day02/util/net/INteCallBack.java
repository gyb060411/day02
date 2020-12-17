package com.example.day02.util.net;

public interface INteCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
