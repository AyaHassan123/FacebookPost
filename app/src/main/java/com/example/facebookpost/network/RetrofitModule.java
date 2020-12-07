package com.example.facebookpost.network;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {

    private  static  final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static synchronized ApiServices provideApiServices(){
        return new Retrofit.Builder()
                .baseUrl(RetrofitModule.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiServices.class);
    }

    public static ApiServices getService() {
        return provideApiServices();
    }
}
