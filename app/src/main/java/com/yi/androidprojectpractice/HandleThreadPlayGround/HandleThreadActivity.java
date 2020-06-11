package com.yi.androidprojectpractice.HandleThreadPlayGround;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yi.androidprojectpractice.databinding.ActivityHandlethreadBinding;

public class HandleThreadActivity extends AppCompatActivity {
    private static final String TAG = "HandleThreadActivity";
    /*HandlerThread mHandlerThread = new HandlerThread("LeoHandlerThread");
    Handler ExampleHandler;*/
    private ExampleHandlerThread mHandlerThread = new ExampleHandlerThread();
    ActivityHandlethreadBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHandlethreadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mHandlerThread.start();
        //ExampleHandler = new Handler(mHandlerThread.getLooper());

        binding.doWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doWorkTask();
            }
        });

        binding.removeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeMsgTask();
            }
        });

        //SystemClock.sleep(5000);
        doWorkTask();

    }

    public void doWorkTask(){
        /*ExampleHandler.postDelayed(new ExampleRunnable1(), 2000);
        ExampleHandler.post(new ExampleRunnable2());
        ExampleHandler.postAtFrontOfQueue(new ExampleRunnable2());*/

        /*mHandlerThread.getHandler().postDelayed(new ExampleRunnable1(), 2000);
        mHandlerThread.getHandler().post(new ExampleRunnable2());
        mHandlerThread.getHandler().postAtFrontOfQueue(new ExampleRunnable2());*/

        Message msg = Message.obtain();
        msg.what = 1;
        msg.arg1 = 32;
        msg.obj = "Own Create Message";

        mHandlerThread.getHandler().sendMessage(msg);

    }

    public void removeMsgTask(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandlerThread.quit();
    }

    class ExampleRunnable1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.i(TAG, "ExampleRunnable1 " + i);
                SystemClock.sleep(1000);
            }
        }
    }

    class ExampleRunnable2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.i(TAG, "ExampleRunnable2 " + i);
                SystemClock.sleep(1000);
            }
        }
    }

}
