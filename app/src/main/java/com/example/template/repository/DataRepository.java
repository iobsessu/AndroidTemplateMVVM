package com.example.template.repository;

import com.example.template.data.api.AccountApi;
import com.example.template.data.api.Api;
import com.example.template.data.bean.User;
import com.kunminx.architecture.data.response.DataResult;
import com.kunminx.architecture.data.response.ResponseStatus;
import com.kunminx.architecture.data.response.ResultSource;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRepository {

    private static final DataRepository dataRepository = new DataRepository();

    private DataRepository() {}

    public static DataRepository getInstance() {
        return dataRepository;
    }

    private final Retrofit retrofit;

    {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private Call<String> userCall;

    public void login(User user, DataResult.Result<String> result) {
        userCall = retrofit.create(AccountApi.class).login();
        userCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                ResponseStatus responseStatus = new ResponseStatus(
                        String.valueOf(response.code()), response.isSuccessful(), ResultSource.NETWORK);
                result.onResult(new DataResult<>(response.body(), responseStatus));
                userCall = null;
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                result.onResult(new DataResult<>(null,
                        new ResponseStatus(t.getMessage(), false, ResultSource.NETWORK)));
                userCall = null;
            }
        });
    }

    public void cancelLogin() {
        if (userCall != null && !userCall.isCanceled()) {
            userCall.cancel();
            userCall = null;
        }
    }

}
