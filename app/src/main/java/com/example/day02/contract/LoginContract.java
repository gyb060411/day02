package com.example.day02.contract;

public class LoginContract {
    public interface LoginView{
        String getName();
        String getPass();
        void getLogin(long string);
    }
    public interface LoginPersenter{
        void login(String name,String pass);
        void getResult(long result);
    }
    public interface LoginModel{
        void getLoginData(String name, String pass);
    }
}
