package com.yi.androidprojectpractice.RecycleViewImageList;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yi.androidprojectpractice.databinding.ActivityImagelistBinding;

import java.util.List;

public class ImageListAvtivity extends AppCompatActivity {

    ActivityImagelistBinding binding;
    RecyclerView recyclerView;
    ImageListViewModel viewModel;
    ImageListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImagelistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.rcview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ImageListAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = new ImageListViewModel(this);
        viewModel.getData().observe(this, new Observer<List<ImageListItem>>() {
            @Override
            public void onChanged(List<ImageListItem> imageListItems) {
                adapter.setImageListItems(imageListItems);
            }
        });
    }
}
