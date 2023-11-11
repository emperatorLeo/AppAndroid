package com.example.appandroid;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.appandroid.databinding.ActivityMainBinding;
import com.example.appandroid.ui.adapter.PhotoAdapter;
import com.example.appandroid.ui.viewmodel.ViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewModel viewModel = new ViewModel();
        viewModel.getPhotoList();
        viewModel.listOfPhotos.observe(this, photos -> {
            PhotoAdapter adapter = new PhotoAdapter(photos);
            adapter.arrayList = photos;
            binding.recyclerView.setAdapter(adapter);
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}