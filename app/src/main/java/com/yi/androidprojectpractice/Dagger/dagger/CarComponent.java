package com.yi.androidprojectpractice.Dagger.dagger;

import com.yi.androidprojectpractice.Dagger.DaggerActivity;

import dagger.Component;

@Component(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {

    //Car getCar();

    void inject(DaggerActivity daggerActivity);
}
