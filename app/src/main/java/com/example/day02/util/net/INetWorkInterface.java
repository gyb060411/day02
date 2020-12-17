package com.example.day02.util.net;

import java.util.HashMap;

public interface INetWorkInterface {
    <T> void get(String url, INteCallBack<T> callBack);

    <T> void post(String url, INteCallBack<T> callBack);

    <T> void post(String url, HashMap<String, String> map, INteCallBack<T> callBack);
}
