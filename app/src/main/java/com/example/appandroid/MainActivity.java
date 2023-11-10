package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appandroid.data.entities.Photos;
import com.example.appandroid.data.network.ApiClient;
import com.example.appandroid.data.network.ApiPhoto;
import com.example.appandroid.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Call<List<Photos>> call = ApiClient.getClient().create(ApiPhoto.class).getPhotos();
        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        Log.d("Leo", "lista: " + response.body().get(i));
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                Log.e("Leo", "message: " + t.getMessage());
            }
        });
    }
}