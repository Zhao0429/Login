package com.example.administrator.mylogin.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtils {

    private static OKHttpUtils okHttpUtils = null;
    private MyHandler myHandler = new MyHandler();
    private OkhttpListener okhttpListener;

    public static OKHttpUtils getInstance() {
        if (okHttpUtils == null) {
            okHttpUtils = new OKHttpUtils();
        }
        return okHttpUtils;
    }

    public void okPost(String url, Map<String, String> params) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            String value = params.get(key);
            builder.add(key, value);
        }
        FormBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = myHandler.obtainMessage();
                message.what = 0;
                message.obj = e.getMessage();
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = myHandler.obtainMessage();
                message.what = 1;
                message.obj = response.body().string();
                myHandler.sendMessage(message);
            }
        });
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            int w = msg.what;
            switch (w) {
                case 0:
                    String error = (String) msg.obj;
                    okhttpListener.Error(error);
                    break;

                case 1:
                    String json = (String) msg.obj;
                    okhttpListener.Success(json);
                    break;
            }
        }
    }


    public void setOkListener(OkhttpListener okListener) {
        this.okhttpListener = okListener;
    }


}
