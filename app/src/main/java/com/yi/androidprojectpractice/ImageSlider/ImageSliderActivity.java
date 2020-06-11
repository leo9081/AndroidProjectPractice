package com.yi.androidprojectpractice.ImageSlider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;

import com.yi.androidprojectpractice.databinding.ActivityImagesliderBinding;

import java.util.List;

public class ImageSliderActivity extends AppCompatActivity {

    ActivityImagesliderBinding binding;
    ImageSliderViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImagesliderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewPager viewPager = binding.viewpager;
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        viewModel = new ImageSliderViewModel();
        viewModel.getMutableLiveData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                adapter.setUrls(strings);
            }
        });
    }
}
