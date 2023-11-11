package com.example.appandroid.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.appandroid.data.entities.Photos;
import com.example.appandroid.data.repository.Repository;
import com.example.appandroid.data.services.Services;
import com.example.appandroid.usecase.GetPhotosUseCase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<ArrayList<Photos>> mutableListOfPhotos;
    public LiveData<ArrayList<Photos>> listOfPhotos;
    private final ArrayList<Photos> savedList;

    public ViewModel(){
        mutableListOfPhotos = new MutableLiveData<>(new ArrayList<>());
        savedList = new ArrayList<>();
        listOfPhotos = mutableListOfPhotos;
    }

    public void getPhotoList(){
        GetPhotosUseCase useCase = new GetPhotosUseCase(new Repository(new Services()));
        useCase.getPhotosList().enqueue(new Callback<ArrayList<Photos>>() {
            @Override
            public void onResponse(Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < 15; i++) {
                        savedList.add(response.body().get(i));
                    }
                    Log.d("Leo", "lista size: " + savedList.size());
                }
                mutableListOfPhotos.setValue(savedList);
            }

            @Override
            public void onFailure(Call<ArrayList<Photos>> call, Throwable t) {
                Log.e("ERROR GETTING PHOTOS", "message: " + t.getMessage());
            }
        });
    }
}
