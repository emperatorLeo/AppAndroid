package com.example.appandroid.usecase;

import com.example.appandroid.data.entities.Photos;
import com.example.appandroid.data.repository.Repository;

import java.util.ArrayList;

import retrofit2.Call;

public class GetPhotosUseCase {
    private final Repository repository;
    public GetPhotosUseCase(Repository repository){
        this.repository = repository;
    }
    public Call<ArrayList<Photos>> getPhotosList(){
      return repository.getPhotosList();
    }
}
