package com.permoveo.matchlayoutmvvm.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by byfieldj on 8/4/17.
 */

public class MatchFactory {

    public static final String BASE_URL = "https://www.okcupid.com/";


    public static MatchService create(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(MatchService.class);


    }
}
