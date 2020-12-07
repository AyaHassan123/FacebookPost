package com.example.facebookpost.network;

import com.example.facebookpost.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("posts")

    //public Call<List<PostModel>> getPost();
    Observable<List<PostModel>> getPost();
}
