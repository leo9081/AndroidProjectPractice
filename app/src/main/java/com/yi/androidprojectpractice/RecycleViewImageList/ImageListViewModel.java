package com.yi.androidprojectpractice.RecycleViewImageList;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yi.androidprojectpractice.classes.OpeartionListener;
import com.yi.androidprojectpractice.classes.Result;

import java.util.List;

public class ImageListViewModel extends ViewModel implements OpeartionListener {
    MutableLiveData<List<ImageListItem>> imageListItemLiveData = new MutableLiveData<>();
    Context context;

    public ImageListViewModel(Context context){
        setData(context);
    }

    public void setData(Context context){
        ImageDataReporstory.getInstance(context).setOperationListener(this).getData();
    }

    public LiveData<List<ImageListItem>> getData(){
        return imageListItemLiveData;
    }

    @Override
    public void onSuccess(Result result) {
        imageListItemLiveData.setValue(((Result.Success<List<ImageListItem>>)result).getData());
    }

    @Override
    public void onError(Result result) {
        Toast.makeText(context,((Result.Error)result).getError().getMessage(),Toast.LENGTH_LONG).show();
    }
}
