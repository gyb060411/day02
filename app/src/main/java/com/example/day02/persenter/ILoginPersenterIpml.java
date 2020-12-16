package com.example.day02.persenter;

import com.example.day02.contract.LoginContract;
import com.example.day02.model.ILoginModelImpl;

public class ILoginPersenterIpml implements LoginContract.LoginPersenter {

    private LoginContract.LoginModel mainModel;
    private LoginContract.LoginView mainView;

    public ILoginPersenterIpml(LoginContract.LoginView mainView) {
        this.mainView = mainView;
        this.mainModel = new ILoginModelImpl(this);
    }

    @Override
    public void login(String name, String pass) {
        mainModel.getLoginData(name, pass);
    }

    @Override
    public void getResult(long result) {
        mainView.getLogin(result);
    }
}
