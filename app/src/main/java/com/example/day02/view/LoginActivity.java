package com.example.day02.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day02.R;
import com.example.day02.base.BaseActivity;
import com.example.day02.contract.LoginContract;
import com.example.day02.persenter.ILoginPersenterIpml;


public class LoginActivity extends BaseActivity<ILoginPersenterIpml> implements LoginContract.LoginView {

    private android.widget.EditText edName;
    private android.widget.EditText edPass;
    private SharedPreferences preferences;
    private boolean name;
    private Button btn;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        edName = (EditText) findViewById(R.id.ed_name);
        edPass = (EditText) findViewById(R.id.ed_pass);
        btn = findViewById(R.id.btn);
        preferences = getPreferences(MODE_PRIVATE);
        name = preferences.getBoolean("name", false);
        if (name){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }else {
            ligon();
        }
    }

    private void ligon() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(getName())&&TextUtils.isEmpty(getPass())){
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    getPersenter().login(getName(),getPass());

                }
            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected ILoginPersenterIpml getPersenter() {
        return new ILoginPersenterIpml(this);
    }

    @Override
    public String getName() {
        return edName.getText().toString();
    }

    @Override
    public String getPass() {
        return edPass.getText().toString();
    }

    @Override
    public void getLogin(long string) {
        if (string>0){
            Toast.makeText(this, "输入正确", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean("name",true);
            edit.commit();
            btn.setText("登录成功");
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }else {
            Toast.makeText(this, "输入错误", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean("name",false);
            edit.commit();
            btn.setText("登录失败");
        }
    }

}