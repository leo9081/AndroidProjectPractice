package com.yi.androidprojectpractice.wallpaperPolling;

import android.app.WallpaperManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.yi.androidprojectpractice.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WallPaperPollingActivity extends AppCompatActivity {

    URL url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        /*Button imageDonwload = findViewById(R.id.image_donwload);
        imageDonwload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask().execute(stringToURL());
            }
        });*/

        ComponentName componentName = new ComponentName(getApplicationContext(),WallPaperPollingService.class);
        JobInfo jobInfo = new JobInfo.Builder(1000,componentName)
                .setPeriodic(15*60*1000)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        int result = jobScheduler.schedule(jobInfo);

        if(result == JobScheduler.RESULT_FAILURE){

        }else{
            Toast.makeText(getBaseContext(),"Set Image Successfuly", Toast.LENGTH_LONG);
        }
    }

    private class DownloadTask extends AsyncTask<URL, Void, Bitmap> {

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

    protected URL stringToURL(){

        try {
            url = new URL("http://api.instgram.com");
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
}
