package com.yi.androidprojectpractice.ServicePlayGround.JobIntentService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yi.androidprojectpractice.databinding.ActivityJobIntentserviceBinding;

public class JobIntentServiceActivity extends AppCompatActivity {

    ActivityJobIntentserviceBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobIntentserviceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void enqueueWork(View v){
        String s = binding.editTextInput.getText().toString();
        Intent serviceIntent = new Intent(this,ExampleJobIntentService.class);
        serviceIntent.putExtra("InputExtra", s);
        ExampleJobIntentService.enquequeWork(this,serviceIntent);
    }
}
