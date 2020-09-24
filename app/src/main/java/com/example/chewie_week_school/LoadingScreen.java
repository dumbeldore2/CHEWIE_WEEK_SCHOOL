package com.example.chewie_week_school;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class LoadingScreen extends AppCompatActivity {

    ProgressBar progressBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        progressBar = findViewById(R.id.progressbar);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();
    }

    public void progressAnimation(){
        ProgresBarAnimation animation = new ProgresBarAnimation(this,progressBar,0f,100f);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);
    }
}