package com.example.appandroid.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appandroid.data.entities.Photos;
import com.example.appandroid.databinding.ItemPhotoBinding;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    public ArrayList<Photos> arrayList;
    private Context context;

    public void setData(ArrayList<Photos> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemPhotoBinding binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photos photo = arrayList.get(position);
        holder.title.setText(photo.getTitle());
        Glide.with(context).load(photo.getUrl()).into(holder.photo);
        holder.deleteButton.setOnClickListener(it -> {
            arrayList.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView photo;
        ImageView deleteButton;

        public ViewHolder(ItemPhotoBinding binding) {
            super(binding.getRoot());
            title = binding.title;
            photo = binding.imagePhoto;
            deleteButton = binding.deleteButton;
        }
    }
}
