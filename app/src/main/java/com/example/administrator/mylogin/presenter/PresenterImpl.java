package com.example.administrator.mylogin.presenter;

import android.util.Log;

import com.example.administrator.mylogin.http.Httpfig;
import com.example.administrator.mylogin.http.LoginListener;
import com.example.administrator.mylogin.model.IModel;
import com.example.administrator.mylogin.model.LoginBean;
import com.example.administrator.mylogin.model.RegBean;
import com.example.administrator.mylogin.view.IMainView;
import com.example.administrator.mylogin.view.RegView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class PresenterImpl implements IPresenter {
    private static final String TAG = "PresenterImpl";

    //登陆
    @Override
    public void getLogin(IModel iModel, final IMainView iMainView) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iMainView.mobile());
        map.put("password", iMainView.password());
        iModel.LoginDate(Httpfig.login_url, map, new LoginListener() {
            @Override
            public void LoginSuccess(String json) {
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                String code = loginBean.getCode();

                if (code.equals("0")) {
                    iMainView.showLoginSuccess();
                } else {
                    iMainView.showLoginError();
                }
            }

            @Override
            public void LoginError(String error) {
                Log.d(TAG, "LoginError-------------------失败: " + error);
            }
        });
    }

    //注册
    @Override
    public void getReg(final IModel iModel, final RegView regView) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", regView.mobile());
        map.put("password", regView.password());
        iModel.LoginDate(Httpfig.login_url, map, new LoginListener() {
            @Override
            public void LoginSuccess(String json) {
                Gson gson = new Gson();
                RegBean regBean = gson.fromJson(json, RegBean.class);
                String code = regBean.getCode();
                if (code.equals("0")) {
                    regView.showRegSuccess();
                } else {
                    regView.showRegError();
                }


            }

            @Override
            public void LoginError(String error) {
                Log.d(TAG, "LoginError-------------------失败: " + error);
            }
        });
    }
}
