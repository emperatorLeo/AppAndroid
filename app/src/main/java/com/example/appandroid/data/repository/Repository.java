package com.example.appandroid.data.repository;

import com.example.appandroid.data.entities.Photos;
import com.example.appandroid.data.services.Services;

import java.util.ArrayList;

import retrofit2.Call;

public class Repository {

    private final Services services;

    public Repository(Services services){
        this.services = services;
    }

    public Call<ArrayList<Photos>> getPhotosList(){
        return services.requestPhotoList();
    }
}
