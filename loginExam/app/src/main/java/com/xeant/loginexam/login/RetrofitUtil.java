package com.xeant.loginexam.login;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private UserApi mUserApi;


    private  Retrofit mRetrofit;

    public RetrofitUtil() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(UserApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mUserApi = mRetrofit.create(UserApi.class);
    }

    public UserApi getUserApi() {
        return mUserApi;
    }

}
