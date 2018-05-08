package com.example.administrator.mylogin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mylogin.R;
import com.example.administrator.mylogin.model.ModelImpl;
import com.example.administrator.mylogin.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    private EditText name;
    private EditText pass;
    private Button login;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initview();
    }

    private void initview() {
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        reg = findViewById(R.id.reg);

        login.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(MainActivity.this,"用户名不存在,请去注册",Toast.LENGTH_LONG).show();

    }


    @Override
    public String mobile() {

        return name.getText().toString();
    }

    @Override
    public String password() {
        return pass.getText().toString();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.login:
                PresenterImpl presenter=new PresenterImpl();
                presenter.getLogin(new ModelImpl(),this);
                break;
            case R.id.reg:
                Intent intent=new Intent(MainActivity.this,RegActivity.class);
                startActivity(intent);
        }
    }
}
