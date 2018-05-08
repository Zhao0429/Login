package com.example.administrator.mylogin.http;

public interface OkhttpListener {
    //成功
    void Success(String json);

    //失败
    void Error(String error);
}
