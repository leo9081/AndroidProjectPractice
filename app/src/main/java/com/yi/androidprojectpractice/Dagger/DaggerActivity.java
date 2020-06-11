package com.yi.androidprojectpractice.Dagger;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yi.androidprojectpractice.Dagger.car.Car;
import com.yi.androidprojectpractice.Dagger.dagger.CarComponent;
import com.yi.androidprojectpractice.Dagger.dagger.DaggerCarComponent;
import com.yi.androidprojectpractice.databinding.ActivityDaggerBinding;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    ActivityDaggerBinding binding;
    //private Car car;
    @Inject
    Car car;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDaggerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CarComponent carComponent = DaggerCarComponent.create();

        //car = carComponent.getCar();
        carComponent.inject(this);
        car.drive();
    }
}
