package com.yi.androidprojectpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yi.androidprojectpractice.Dagger.DaggerActivity;
import com.yi.androidprojectpractice.HandleThreadPlayGround.HandleThreadActivity;
import com.yi.androidprojectpractice.ImageSlider.ImageSliderActivity;
import com.yi.androidprojectpractice.RecycleViewImageList.ImageListAvtivity;
import com.yi.androidprojectpractice.ServicePlayGround.Service.ServiceActivity;
import com.yi.androidprojectpractice.wallpaperPolling.WallPaperPollingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Start = findViewById(R.id.start);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ImageListAvtivity.class);
                startActivity(i);
            }
        });

    }
}
