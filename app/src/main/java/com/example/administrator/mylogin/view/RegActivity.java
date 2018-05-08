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

public class RegActivity extends AppCompatActivity implements RegView, View.OnClickListener {

    private Button reg_2;
    private EditText name_reg;
    private EditText pass_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        initView();

    }

    private void initView() {
        reg_2 = findViewById(R.id.reg_2);
        name_reg = findViewById(R.id.name_reg);
        pass_reg = findViewById(R.id.pass_reg);


        reg_2.setOnClickListener(this);
    }

    @Override
    public void showRegSuccess() {


        Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showRegError() {
//        Toast.makeText(RegActivity.this, "注册失败", Toast.LENGTH_LONG).show();
    }

    @Override
    public String mobile() {
        return name_reg.getText().toString();
    }

    @Override
    public String password() {
        return pass_reg.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.reg_2:
//                if (name_reg.equals("") && pass_reg.equals("")) {
//                    Toast.makeText(RegActivity.this, "用户名密码不能为空", Toast.LENGTH_LONG).show();
//
//                } else {
                    PresenterImpl presenter = new PresenterImpl();
                    presenter.getReg(new ModelImpl(), this);


//                }
                break;
        }
    }
}
