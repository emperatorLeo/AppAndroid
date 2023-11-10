package com.example.appandroid.data.network;

import com.example.appandroid.data.entities.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPhoto {
    @GET("photos")
    Call<List<Photos>> getPhotos();

}
