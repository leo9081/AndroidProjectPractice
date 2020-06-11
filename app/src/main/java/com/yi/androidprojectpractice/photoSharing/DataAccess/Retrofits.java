package com.yi.androidprojectpractice.photoSharing.DataAccess;

import retrofit2.Retrofit;

public class Retrofits {
    static Retrofits retrofits;
    Retrofit retrofit;

    public Retrofits(){
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .build();
    }

    public static synchronized Retrofits getInstance(){
        if(retrofits == null){
            try {
                retrofits = new Retrofits();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retrofits;
    }

}
