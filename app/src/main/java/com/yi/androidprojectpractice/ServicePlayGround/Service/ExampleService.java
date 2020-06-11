package com.yi.androidprojectpractice.ServicePlayGround.Service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.yi.androidprojectpractice.R;

import static com.yi.androidprojectpractice.ServicePlayGround.App.CHANNEL_ID;

//Since Orio, Service no longer running forever auto. If we want to let service running on forever, we have to add notification.
//It is a different kind of notification, it will stack at the top of the screen can not be killed.
//If we want to use background service, we can use JobService instead.
public class ExampleService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(this,ServiceActivity.class);
        //put intent to notification
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,0);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Example Sercie")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();

        //display notificaiton
        startForeground(1,notification);

        //do heavy work on a background thread
        //stopSelf();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
