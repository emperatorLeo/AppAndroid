package com.example.appandroid.data.services;

import com.example.appandroid.data.entities.Photos;
import com.example.appandroid.data.network.ApiClient;
import com.example.appandroid.data.network.ApiPhoto;

import java.util.ArrayList;

import retrofit2.Call;

public class Services {

    public Call<ArrayList<Photos>> requestPhotoList(){
        return  ApiClient.getClient().create(ApiPhoto.class).getPhotos();
    }
}
