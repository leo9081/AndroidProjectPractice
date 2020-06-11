package com.yi.androidprojectpractice.photoSharing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yi.androidprojectpractice.classes.OpeartionListener;
import com.yi.androidprojectpractice.classes.Result;
import com.yi.androidprojectpractice.photoSharing.DataAccess.Models.Photo;
import com.yi.androidprojectpractice.photoSharing.DataAccess.PhotoListData;

import java.util.List;

public class PhotoListViewModel extends ViewModel {
    MutableLiveData<List<Photo>> photos = new MutableLiveData<>();
    PhotoListData photoListData;
    String UserId;

    public PhotoListViewModel(String UserId){
        this.UserId = UserId;
        photoListData = new PhotoListData();
    }

    public void setData(){
        photoListData.setOperationListener(photoDownloadListener);
        photoListData.getAllPhotos(UserId);
    }

    public LiveData<List<Photo>> getData(){
        return photos;
    }

    OpeartionListener photoDownloadListener = new OpeartionListener() {
        @Override
        public void onSuccess(Result result) {
            photos.setValue(((Result.Success<List<Photo>>) result).getData());
        }

        @Override
        public void onError(Result result) {

        }
    };

}
