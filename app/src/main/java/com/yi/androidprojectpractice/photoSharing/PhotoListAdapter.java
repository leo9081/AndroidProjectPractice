package com.yi.androidprojectpractice.photoSharing;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.yi.androidprojectpractice.R;
import com.yi.androidprojectpractice.photoSharing.DataAccess.Models.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.photoListViewHolder> {

    List<Photo> photoList = new ArrayList<>();
    ImageLoader imageLoader;

    public void setPhotoList( List<Photo> photoList){
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public photoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(),R.layout.item_image,parent);
        return new photoListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull photoListViewHolder holder, int position) {
        if(imageLoader==null) imageLoader = BitmapController.getInstance().getImageLoader();

        holder.networkImageView.setImageUrl(photoList.get(position).imageURL,imageLoader);
        holder.title.setText(photoList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class photoListViewHolder extends RecyclerView.ViewHolder{
        NetworkImageView networkImageView;
        TextView title;

        public photoListViewHolder(@NonNull View itemView) {
            super(itemView);
            networkImageView = itemView.findViewById(R.id.image_donwload);
            title = itemView.findViewById(R.id.imageTitle);
        }
    }
}
