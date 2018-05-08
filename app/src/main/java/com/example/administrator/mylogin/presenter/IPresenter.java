package com.example.administrator.mylogin.presenter;

import com.example.administrator.mylogin.model.IModel;
import com.example.administrator.mylogin.view.IMainView;
import com.example.administrator.mylogin.view.RegView;

public interface IPresenter {
    void getLogin(IModel iModel, IMainView iMainView);

    void getReg(IModel iModel, RegView regView);
}
