package com.bruce.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String baseUrl = "https://publicobject.com";
    /**
     * 声明请求的接口
     */
    public static NetWorkService netWorkService;

    /**
     * 网络请求框架
     */
    public static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //让框架自动实现我们的请求接口,让我们的请求接口可以被调用
        netWorkService = retrofit.create(NetWorkService.class);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        Call<String> call = netWorkService.get("helloworld.txt");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                Log.w("tag", "result = " + result);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("请求失败");
                Log.w("tag", "请求失败");
            }
        });
        //
    }
}
