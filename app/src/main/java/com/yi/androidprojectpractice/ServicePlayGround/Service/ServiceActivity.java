package com.yi.androidprojectpractice.ServicePlayGround.Service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yi.androidprojectpractice.databinding.ActivityServiceBinding;

public class ServiceActivity extends AppCompatActivity {

    ActivityServiceBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void startService(View v){
        String input = binding.editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this,ExampleService.class);
        serviceIntent.putExtra("inputExtra",input);
        //if app is in background, this will throw exception and crush
        //startService(serviceIntent);

        //start service, if app is in background
        ContextCompat.startForegroundService(this,serviceIntent);
    }

    public void stopService(View v){
        Intent serviceIntent = new Intent(this,ExampleService.class);
        stopService(serviceIntent);
    }
}
