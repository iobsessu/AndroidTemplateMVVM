package com.example.template.data.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountApi {

    @GET("/iobsessu/server/posts")
    Call<String> login();

}
