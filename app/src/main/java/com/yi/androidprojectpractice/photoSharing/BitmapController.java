package com.yi.androidprojectpractice.photoSharing;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class BitmapController extends Application {

    RequestQueue requestQueue;
    ImageLoader imageLoader;
    static BitmapController bitmapController;


    private BitmapController(){

    }

    public static BitmapController getInstance(){
        if(bitmapController == null){
            bitmapController = new BitmapController();
        }
        return bitmapController;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public ImageLoader getImageLoader(){
        if(imageLoader == null){
            imageLoader = new ImageLoader(getRequestQueue(),new LRUBitmapCache());
        }

        return imageLoader;
    }


}
