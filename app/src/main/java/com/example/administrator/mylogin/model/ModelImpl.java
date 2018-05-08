package com.example.administrator.mylogin.model;

import com.example.administrator.mylogin.http.LoginListener;
import com.example.administrator.mylogin.http.OKHttpUtils;
import com.example.administrator.mylogin.http.OkhttpListener;
import com.example.administrator.mylogin.http.RegListener;

import java.util.Map;

public class ModelImpl implements IModel {
    @Override
    public void LoginDate(String url, Map<String, String> map, final LoginListener loginListener) {
        OKHttpUtils okHttpUtils=new OKHttpUtils();
        okHttpUtils.okPost(url,map);
        okHttpUtils.setOkListener(new OkhttpListener() {
            @Override
            public void Success(String json) {
                loginListener.LoginSuccess(json);
            }

            @Override
            public void Error(String error) {
                loginListener.LoginError(error);
            }
        });
    }

    @Override
    public void RegDate(String url, Map<String, String> map, final RegListener regListener) {
        OKHttpUtils okHttpUtils=new OKHttpUtils();
        okHttpUtils.okPost(url,map);
        okHttpUtils.setOkListener(new OkhttpListener() {
            @Override
            public void Success(String json) {
                regListener.RegSuccess(json);
            }

            @Override
            public void Error(String error) {
                regListener.RegError(error);
            }
        });
    }
}
