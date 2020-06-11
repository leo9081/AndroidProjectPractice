package com.yi.androidprojectpractice.ServicePlayGround.JobService;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yi.androidprojectpractice.R;


public class ExampleRunnable implements Runnable {
    private static final String TAG = "ExampleRunnable";

    private int count;
    View v;

    Handler mainHandler = new Handler();

    ExampleRunnable(int count, View v){
        this.count = count;
        this.v = v;
    }

    @Override
    public void run() {
        for(int i = 0; i<count; i++){
            Log.e(TAG, "startThread: " + i);
            if(i == 5){
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Button b = v.findViewById(R.id.Sechdule_service);
                        b.setText("50%");
                    }
                });
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
