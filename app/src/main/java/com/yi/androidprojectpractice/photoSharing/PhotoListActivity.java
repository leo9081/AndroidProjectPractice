package com.yi.androidprojectpractice.photoSharing;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yi.androidprojectpractice.databinding.ActivityPhotolistBinding;
import com.yi.androidprojectpractice.photoSharing.DataAccess.Models.Photo;

import java.util.List;

public class PhotoListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PhotoListAdapter adapter;
    PhotoListViewModel viewModel;
    ActivityPhotolistBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotolistBinding.inflate(getLayoutInflater());
        recyclerView = binding.photoList;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PhotoListAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new PhotoListViewModel("001");

        viewModel.getData().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                adapter.setPhotoList(photos);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
