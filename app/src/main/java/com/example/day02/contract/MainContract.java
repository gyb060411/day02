package com.example.day02.contract;

import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;
import com.example.day02.util.net.INteCallBack;

public class MainContract {
    public interface MainView {
        void getBanner(BannerBean bannerBean);
        void getData(ProjectBean projectBean);
        void getList(ListBean listBean);
        void getResult(String result);
    }

    public interface MainModel {
        <T> void getMod(String url, INteCallBack<T> callBack);
    }

    public interface MainPersenter {
        void per();
        void per1();
        void per2();
    }
}
