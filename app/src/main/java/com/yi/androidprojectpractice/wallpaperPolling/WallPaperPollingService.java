package com.yi.androidprojectpractice.wallpaperPolling;

import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WallPaperPollingService extends JobService {

    URL url;

    @Override
    public void onCreate() {
        super.onCreate();
        Intent i = new Intent();
        String u = i.getStringExtra("downloadUrl");
        url = stringToURL(u);
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        new WallPaperPolling().execute(url);
        return false;
    }

    class WallPaperPolling extends AsyncTask<URL,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(URL... urls) {
            URL url = urls[0];
            HttpURLConnection httpURLConnection = null;

            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                return BitmapFactory.decodeStream(bufferedInputStream);

            }catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap!=null){
                setWallPaper(bitmap);
            }else{
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        }
    }

    protected URL stringToURL(String u){

        try {
            url = new URL(u);
            return url;
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        return null;
    }

    private void setWallPaper(Bitmap bitmap){
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {
            wallpaperManager.setBitmap(bitmap);
        }catch (IOException e){
            Toast.makeText(getApplicationContext(),"Set WallPater fail",Toast.LENGTH_LONG);
        }

    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
