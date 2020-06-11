package com.yi.androidprojectpractice.RecycleViewImageList;

public class ImageListItem {
    String ImageUrl;
    int Like;
    String Discription;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getLike() {
        return Like;
    }

    public void setLike(int Like) {
        this.Like = Like;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public ImageListItem(String ImageUrl, int Like, String Discription){
        this.ImageUrl = ImageUrl;
        this.Like = Like;
        this.Discription = Discription;
    }

}
