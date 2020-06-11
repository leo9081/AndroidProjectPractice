package com.yi.androidprojectpractice.ServicePlayGround.JobService;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yi.androidprojectpractice.R;

public class JobServiceActivity extends AppCompatActivity {
    private static final String TAG = "ServiceActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_service);

        Button schedul_service = findViewById(R.id.Sechdule_service);
        schedul_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scheduleJob();
                startThread(view);
            }
        });

        Button cancel_service = findViewById(R.id.cancel_service);
        cancel_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancelJob();
                endThread();
            }
        });

    }

    ExampleThread thread;
    public void startThread(View v){

        thread = new ExampleThread(10,v);
        thread.setStopworker(false);
        thread.start();

        /*ExampleRunnable runnable = new ExampleRunnable(10, v);
        new Thread(runnable).start();*/
    }

    public void endThread(){
        thread.setStopworker(true);
    }


    public void scheduleJob(){
        ComponentName componentName = new ComponentName(this, ExampleJobService.class);
        JobInfo info = new JobInfo.Builder(123,componentName)
                .setPeriodic(15*60*1000)
                .setPersisted(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = jobScheduler.schedule(info);

        if(resultCode == JobScheduler.RESULT_SUCCESS){
            Log.d("ServiceActivity", "job start successful");
        }else{
            Log.d("ServiceActivity", "job start fail");
        }
    }

    public void cancelJob(){
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.cancel(123);
        Log.d("ServiceActivity", "job canceled");
    }

}
