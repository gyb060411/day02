package com.example.day02.util.net;

import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiServer {
//    http://cdwan.cn:7000/exam2003/abannerlist.json
//    http://cdwan.cn:7000/exam2003/anewslist.json
//    http://cdwan.cn:7000/exam2003/astudent.json

    @GET
    Observable<ResponseBody>get(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody>post(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody>post(@Url String url, @FieldMap HashMap<String,String> map);
}
