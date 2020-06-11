package com.yi.androidprojectpractice.ServicePlayGround.JobService;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yi.androidprojectpractice.R;


public class ExampleThread extends Thread {
    private static final String TAG = "ExampleThread";

    private int count;
    View v;
    boolean stopworker = false;

    ExampleThread(int count, View v){
        this.count = count;
        this.v = v;
    }

    public void setStopworker(boolean flag){
        stopworker = flag;
    }

    @Override
    public void run() {
        for(int i = 0; i<count; i++){
            if(stopworker){
                return;
            }

            if(i == 5){
                //ERROR: Only the original thread that created a view hierarchy can touch its views.
               // Looper.prepare();
                Handler h = new Handler(Looper.getMainLooper());

                h.post(new Runnable() {
                    @Override
                    public void run() {
                        Button b = v.findViewById(R.id.Sechdule_service);
                        b.setText("50%");
                    }
                });

                //Looper.loop();
            }


            Log.e(TAG, "startThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
