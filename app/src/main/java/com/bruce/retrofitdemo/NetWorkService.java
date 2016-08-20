package com.bruce.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public interface NetWorkService {

    /**
     * 一个get请求的请求接口,返回是字符串
     *
     * @return
     */
    @GET("/{path}")
    Call<String> get(@Path("path") String s);

}
