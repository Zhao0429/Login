package com.example.administrator.mylogin.model;

import com.example.administrator.mylogin.http.LoginListener;
import com.example.administrator.mylogin.http.OkhttpListener;
import com.example.administrator.mylogin.http.RegListener;

import java.util.Map;

public interface IModel {

    void LoginDate(String url, Map<String,String> map, LoginListener loginListener);
    void RegDate(String url, Map<String,String> map, RegListener regListener);
}
