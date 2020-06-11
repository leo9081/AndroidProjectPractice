package com.yi.androidprojectpractice.ServicePlayGround.JobService;

import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.util.Log;

import java.util.logging.Handler;

public class ExampleJobService extends JobService {
    private String TAG = "I am at";
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        jobTasks(jobParameters);

        return true;
    }

    public void jobTasks(final JobParameters jobParameters){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 10; i++){
                    Log.d(TAG, "run" + i);

                    if(jobCancelled){
                        return;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "job finished");
                jobFinished(jobParameters,false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "job failed befor completion");

        jobCancelled = true;

        return false;
    }
}
