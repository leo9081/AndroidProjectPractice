package com.yi.androidprojectpractice.ImageSlider;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yi.androidprojectpractice.classes.OpeartionListener;
import com.yi.androidprojectpractice.classes.Result;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderViewModel extends ViewModel implements OpeartionListener {
    MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>();

    public ImageSliderViewModel(){
        setMutableLiveData();
    }

    public void setMutableLiveData(){
        List<String> temp = new ArrayList<>();
        temp.add("https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg");
        temp.add("https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg");
        temp.add("https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg");
        temp.add("https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg");
        mutableLiveData.setValue(temp);
    }

    public LiveData<List<String>> getMutableLiveData(){
        return mutableLiveData;
    }

    @Override
    public void onSuccess(Result result) {

    }

    @Override
    public void onError(Result result) {

    }
}
