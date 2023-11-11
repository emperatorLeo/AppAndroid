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
        PhotoAdapter adapter = new PhotoAdapter();
        viewModel.listOfPhotos.observe(this, photos -> {
            adapter.setData(photos);
            adapter.arrayList = photos;
            binding.recyclerView.setAdapter(adapter);
            binding.progressBar.setVisibility(View.INVISIBLE);
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        binding.refreshButton.setOnClickListener(click -> viewModel.refreshData());

    }
}