package com.example.day02.model;

import com.example.day02.contract.LoginContract;
import com.example.day02.persenter.ILoginPersenterIpml;

public class ILoginModelImpl implements LoginContract.LoginModel {

    private ILoginPersenterIpml persenterIpml;

    public ILoginModelImpl(ILoginPersenterIpml persenterIpml) {
        this.persenterIpml = persenterIpml;
    }

    @Override
    public void getLoginData(String name,String pass) {
        if (name.equals("H2003xs")&&pass.equals("H2003")){
            persenterIpml.getResult(1);
        }else {
            persenterIpml.getResult(-1);
        }

    }
}
