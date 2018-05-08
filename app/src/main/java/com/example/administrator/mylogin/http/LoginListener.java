package com.example.administrator.mylogin.http;

public interface LoginListener {
    void LoginSuccess(String json);
    void LoginError(String error);
}
