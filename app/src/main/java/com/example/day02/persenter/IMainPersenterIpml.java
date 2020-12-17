package com.example.day02.persenter;

import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.contract.MainContract;
import com.example.day02.model.IMainModelIpml;
import com.example.day02.util.net.ApiServer;
import com.example.day02.util.net.INteCallBack;
import com.example.day02.util.net.URLConstant;

public class IMainPersenterIpml implements MainContract.MainPersenter {

    private MainContract.MainModel mainModel;
    private MainContract.MainView mainView;

    public IMainPersenterIpml(MainContract.MainView mainView) {
        this.mainView = mainView;
        this.mainModel = new IMainModelIpml(this);
    }

    @Override
    public void per() {
        mainModel.getMod(URLConstant.BANNER, new INteCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                mainView.getBanner(bannerBean);
            }

            @Override
            public void onFail(String err) {
                mainView.getResult(err);
            }
        });
    }

    @Override
    public void per1() {
        mainModel.getMod(URLConstant.NEWDATA, new INteCallBack<ProjectBean>() {
            @Override
            public void onSuccess(ProjectBean projectBean) {
                mainView.getData(projectBean);
            }

            @Override
            public void onFail(String err) {
                mainView.getResult(err);
            }
        });
    }

    @Override
    public void per2() {
        mainModel.getMod(URLConstant.NEWLIST, new INteCallBack<ListBean>() {
            @Override
            public void onSuccess(ListBean listBean) {
                mainView.getList(listBean);
            }

            @Override
            public void onFail(String err) {
                mainView.getResult(err);
            }
        });
    }
}
