package com.yi.androidprojectpractice.photoSharing.DataAccess;

import com.yi.androidprojectpractice.classes.OpeartionListener;
import com.yi.androidprojectpractice.classes.Operation;
import com.yi.androidprojectpractice.photoSharing.DataAccess.Models.Photo;

import java.util.List;

public class PhotoListData implements Operation {

    OpeartionListener mListener;

    @Override
    public PhotoListData setOperationListener(OpeartionListener operationListener) {
        mListener = operationListener;
        return this;
    }

    public PhotoListData(){

    }

    public void getAllPhotos(String userId){

    }

}
