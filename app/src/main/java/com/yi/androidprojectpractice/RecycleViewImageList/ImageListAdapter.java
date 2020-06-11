package com.yi.androidprojectpractice.RecycleViewImageList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yi.androidprojectpractice.R;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ItemViewHolder> {
    List<ImageListItem> imageListItems = new ArrayList<>();
    Context context;

    public ImageListAdapter(Context context){
        this.context = context;
    }

    public void setImageListItems( List<ImageListItem> imageListItems){
        this.imageListItems = imageListItems;
        this.notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        TextView likes;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.imageTitle);
            this.likes = itemView.findViewById(R.id.likes);
            this.imageView = itemView.findViewById(R.id.imageh);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagelist,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.textView.setText(imageListItems.get(position).getDiscription());
        holder.likes.setText(imageListItems.get(position).getLike());

        Picasso.get().load(imageListItems.get(position).ImageUrl).resize(200,200).centerCrop().fit().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageListItems.size();
    }


}
