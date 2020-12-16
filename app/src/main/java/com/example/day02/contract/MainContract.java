package com.example.day02.contract;

import com.example.day02.bean.BannerBean;
import com.example.day02.bean.ListBean;
import com.example.day02.bean.ProjectBean;

public class MainContract {
    public interface MainView{
        void onNext(BannerBean bannerBean);
        void onNext(ProjectBean projectBean);
        void onNext(ListBean listBean);
        void onError(String string);
    }
    public interface MainModel{
        void mod(MainPersenter persenter);
        void mod1(MainPersenter persenter);
        void mod2(MainPersenter persenter);
    }
    public interface MainPersenter{
        void per();
        void per1();
        void per2();
        void onNext(BannerBean bannerBean);
        void onNext(ProjectBean projectBean);
        void onNext(ListBean listBean);
        void onError(String string);
    }
}
