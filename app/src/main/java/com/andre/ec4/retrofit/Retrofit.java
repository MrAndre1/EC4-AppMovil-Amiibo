package com.andre.ec4.retrofit;

import android.app.Application;

import com.andre.ec4.interfaz.AmiiboApiService;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends Application {
    public static final String BASE_URL = "https://amiiboapi.com/api/";
    private AmiiboApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(AmiiboApiService.class);
    }
    public AmiiboApiService getApiService() {
        return apiService;
    }
}
