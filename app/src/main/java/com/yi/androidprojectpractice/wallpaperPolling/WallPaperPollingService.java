package com.yi.androidprojectpractice.wallpaperPolling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;

import java.net.URL;

public class WallPaperPollingService extends JobService {


    @Override
    public boolean onStartJob(JobParameters params) {
        new WallPaperPolling().execute();
        return false;
    }

    class WallPaperPolling extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            //check if new image

            URL url = null;


            Intent i = new Intent(getBaseContext(),WallPaperDonwload.class);
            i.putExtra("downloadUrl", url);
            startActivity(i);

            return null;
        }
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
