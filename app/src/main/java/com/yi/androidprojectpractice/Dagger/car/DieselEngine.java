package com.yi.androidprojectpractice.Dagger.car;

import android.util.Log;

import com.yi.androidprojectpractice.Dagger.car.Engine;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    private static final String TAG = "Car";

    @Inject
    public DieselEngine(){}

    @Override
    public void start() {
        Log.i(TAG, "Diesel Engine start!");
    }
}
