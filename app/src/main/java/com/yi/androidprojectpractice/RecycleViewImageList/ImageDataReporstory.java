package com.yi.androidprojectpractice.RecycleViewImageList;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yi.androidprojectpractice.classes.OpeartionListener;
import com.yi.androidprojectpractice.classes.Operation;
import com.yi.androidprojectpractice.classes.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ImageDataReporstory implements Operation {
    static ImageDataReporstory instance;
    OpeartionListener mListener;
    RequestQueue requestQueue;

    private ImageDataReporstory(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    public static synchronized ImageDataReporstory getInstance(Context context){
        if(instance == null){
            instance = new ImageDataReporstory(context);
        }
        return instance;
    }


    @Override
    public ImageDataReporstory setOperationListener(OpeartionListener operationListener) {
        this.mListener = operationListener;
        return instance;
    }

    public void getData() {
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray =  response.getJSONArray("hits");

                    List<ImageListItem> imageListItems = new ArrayList<>();

                    for(int i = 0 ; i < jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);

                        String imageUrl = object.getString("webformatURL");
                        String creatorName = object.getString("user");
                        int like = object.getInt("likes");

                        ImageListItem imageListItem = new ImageListItem(imageUrl,like,creatorName);
                        imageListItems.add(imageListItem);
                    }

                    mListener.onSuccess(new Result.Success<>(imageListItems));
                } catch (JSONException e) {
                    e.printStackTrace();
                    mListener.onError(new Result.Error(e));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mListener.onError(new Result.Error(error));
            }
        });

        requestQueue.add(request);
    }
}
