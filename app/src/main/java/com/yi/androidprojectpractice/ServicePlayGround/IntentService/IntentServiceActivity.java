package com.yi.androidprojectpractice.ServicePlayGround.IntentService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.yi.androidprojectpractice.databinding.ActivityIntentserviceBinding;

public class IntentServiceActivity extends AppCompatActivity {

    ActivityIntentserviceBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntentserviceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void startIntentService(View v){
        String input = binding.editTextInput.getText().toString();
        Intent serviceIntent = new Intent(this, ExampleIntentService.class);
        serviceIntent.putExtra("inputExtra", input);
        ContextCompat.startForegroundService(this,serviceIntent);
    }
}
