package com.yi.androidprojectpractice.Dagger.dagger;

import com.yi.androidprojectpractice.Dagger.car.DieselEngine;
import com.yi.androidprojectpractice.Dagger.car.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {
    @Binds
    abstract Engine getDieselEngine(DieselEngine engine);
}
