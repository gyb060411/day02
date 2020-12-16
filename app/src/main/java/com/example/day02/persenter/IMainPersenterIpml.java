package com.example.day02.persenter;

import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;
import com.example.day02.model.IMainModelIpml;

public class IMainPersenterIpml implements MainContract.MainPersenter {

    private MainContract.MainModel mainModel;
    private MainContract.MainView mainView;

    public IMainPersenterIpml(MainContract.MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new IMainModelIpml();
    }

    @Override
    public void per() {
        mainModel.mod(this);
    }

    @Override
    public void per1() {
        mainModel.mod1(this);
    }

    @Override
    public void per2() {
        mainModel.mod2(this);
    }

    @Override
    public void onNext(BannerBean bannerBean) {
        mainView.onNext(bannerBean);
    }

    @Override
    public void onNext(ProjectBean projectBean) {
        mainView.onNext(projectBean);
    }

    @Override
    public void onNext(ListBean listBean) {
        mainView.onNext(listBean);
    }

    @Override
    public void onError(String string) {
        mainView.onError(string);
    }
}
