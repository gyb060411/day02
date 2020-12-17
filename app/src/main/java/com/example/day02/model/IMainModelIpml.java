package com.example.day02.model;

import com.example.day02.util.net.ApiServer;
import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;
import com.example.day02.util.net.INteCallBack;
import com.example.day02.util.net.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IMainModelIpml implements MainContract.MainModel {
    private MainContract.MainPersenter persenter;

    public IMainModelIpml(MainContract.MainPersenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public <T> void getMod(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}
