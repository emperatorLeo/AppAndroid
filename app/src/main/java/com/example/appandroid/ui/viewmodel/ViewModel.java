package com.example.appandroid.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.appandroid.data.entities.Photos;

import java.util.ArrayList;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<ArrayList<Photos>> mutableListOfPhotos;
    public LiveData<ArrayList<Photos>> listOfPhotos;

    public ViewModel(){
        mutableListOfPhotos = new MutableLiveData<>(new ArrayList<>());
        listOfPhotos = mutableListOfPhotos;
    }
}
