package com.example.day02.api;

import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
//    http://cdwan.cn:7000/exam2003/abannerlist.json
//    http://cdwan.cn:7000/exam2003/anewslist.json
//    http://cdwan.cn:7000/exam2003/astudent.json
    String baseUrl="http://cdwan.cn:7000/exam2003/";
    @GET("abannerlist.json")
    Observable<BannerBean>getBanner();
    @GET("anewslist.json")
    Observable<ProjectBean>getData();
    @GET("astudent.json")
    Observable<ListBean>getList();
}
