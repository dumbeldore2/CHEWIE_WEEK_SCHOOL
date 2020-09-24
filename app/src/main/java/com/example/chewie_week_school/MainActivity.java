package com.example.chewie_week_school;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //atributen
    Button addLes;
    DatabaseVak databaseVak;
    Button vak1;
    Button vak2;
    Button vak3;
    Button vak4;
    Button vak5;
    Button vak6;
    int aangeklikt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        //variabelen declaratie
        addLes = findViewById(R.id.addLesButton);
        databaseVak = new DatabaseVak(this);
        vak1 = findViewById(R.id.buttonVak1);
        vak2 = findViewById(R.id.buttonVak2);
        vak3 = findViewById(R.id.buttonVak3);
        vak4 = findViewById(R.id.buttonVak4);
        vak5 = findViewById(R.id.buttonVak5);
        vak6 = findViewById(R.id.buttonVak6);
        aangeklikt = 0;

        //functies declaren
        databaseVak.insertZesVaken();
        updateButtons();
        clickOnListView();
        changeFun();

    }

    public void clickOnListView(){
        vak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                    intent.putExtra("id",1);
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        Intent intent = new Intent(getApplicationContext(),Weken.class);
                        intent.putExtra("id",1);
                        startActivity(intent);
                    }
                }
            }
        });
        vak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                    intent.putExtra("id",2);
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        Intent intent = new Intent(getApplicationContext(),Weken.class);
                        intent.putExtra("id",2);
                        startActivity(intent);
                    }
                }
            }
        });
        vak3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                    intent.putExtra("id",3);
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        Intent intent = new Intent(getApplicationContext(),Weken.class);
                        intent.putExtra("id",3);
                        startActivity(intent);
                    }
                }
            }
        });
        vak4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                    intent.putExtra("id",4);
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        Intent intent = new Intent(getApplicationContext(),Weken.class);
                        intent.putExtra("id",4);
                        startActivity(intent);
                    }
                }
            }
        });
        vak5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                    intent.putExtra("id",5);
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        Intent intent = new Intent(getApplicationContext(),Weken.class);
                        intent.putExtra("id",5);
                        startActivity(intent);
                    }
                }
            }
        });
        vak6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                    intent.putExtra("id",6);
                    startActivity(intent);
                } else {
                    if (aangeklikt == 0){
                        Intent intent = new Intent(getApplicationContext(),Weken.class);
                        intent.putExtra("id",6);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    public void updateButtons(){
        updateInnerFun(vak1,1);
        updateInnerFun(vak2,2);
        updateInnerFun(vak3,3);
        updateInnerFun(vak4,4);
        updateInnerFun(vak5,5);
        updateInnerFun(vak6,6);
    }

    public void updateInnerFun(Button button, int id){
        System.out.println(databaseVak.isErEenFalse(id) + "lol");
        System.out.println("false");
        if (!databaseVak.isErEenFalse(id)){
            button.setBackgroundResource(R.drawable.colorgreenmain);
        }
        if (databaseVak.isErEenFalse(id)){
            button.setBackgroundResource(R.drawable.colorredmain);
        }
        button.setText(databaseVak.getLetters(id-1));
    }

    public void changeFun(){
        addLes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(aangeklikt);
                if (aangeklikt == 0){
                    aangeklikt = 1;
                } else {
                    if (aangeklikt == 1){
                        aangeklikt = 0;
                    }
                }
            }
        });
    }
}