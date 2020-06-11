package com.yi.androidprojectpractice.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        /*if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context,"System boots", Toast.LENGTH_LONG).show();
        }*/

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConnnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if(noConnnectivity){
                Toast.makeText(context,"connectivity lost", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context,"connectivity start", Toast.LENGTH_LONG).show();
            }
        }
    }
}
