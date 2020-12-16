package com.example.day02.model;

import com.example.day02.api.ApiServer;
import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IMainModelIpml implements MainContract.MainModel {
    @Override
    public void mod(MainContract.MainPersenter persenter) {
        new Retrofit.Builder()
                .baseUrl(ApiServer.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BannerBean bannerBean) {
                        persenter.onNext(bannerBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        persenter.onError("网络异常："+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void mod1(MainContract.MainPersenter persenter) {
        new Retrofit.Builder()
                .baseUrl(ApiServer.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProjectBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ProjectBean projectBean) {
                        persenter.onNext(projectBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        persenter.onError("网络异常："+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void mod2(MainContract.MainPersenter persenter) {
        new Retrofit.Builder()
                .baseUrl(ApiServer.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ListBean listBean) {
                        persenter.onNext(listBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        persenter.onError("网络异常："+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
