package com.yi.androidprojectpractice.Dagger.dagger;

import com.yi.androidprojectpractice.Dagger.car.Engine;
import com.yi.androidprojectpractice.Dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {
    @Binds
    abstract Engine getPetrolEngine(PetrolEngine engine);
}
