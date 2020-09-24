package com.example.chewie_week_school;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgresBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private float form;
    private float to;

    public ProgresBarAnimation(Context context, ProgressBar progressBar,float from,float to){
        this.context = context;
        this.progressBar = progressBar;
        this.form = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = form + (to - form) * interpolatedTime;
        progressBar.setProgress((int)value);

        if (value == to){
            Intent intent = new Intent(context,MainActivity.class);
            context.startActivity(intent);
        }
    }
}
