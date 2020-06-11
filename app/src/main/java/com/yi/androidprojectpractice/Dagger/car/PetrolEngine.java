package com.yi.androidprojectpractice.Dagger.car;

import android.util.Log;

import com.yi.androidprojectpractice.Dagger.car.Engine;

import javax.inject.Inject;

public class PetrolEngine implements Engine {
    private static final String TAG = "Car";

    @Inject
    public PetrolEngine(){}

    @Override
    public void start() {
        Log.i(TAG, "Petrol Engine start!");
    }
}
