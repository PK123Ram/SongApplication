package com.example.songapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String URL = "http://starlord.hackerearth.com";

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        }
        return retrofit;
    }
}
