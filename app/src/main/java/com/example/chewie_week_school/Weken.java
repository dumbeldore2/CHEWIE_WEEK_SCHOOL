package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Weken extends AppCompatActivity {
    Intent get;
    int id;
    int procent;
    DatabaseVak databaseVak;
    TextView week1;
    TextView week2;
    TextView week3;
    TextView week4;
    TextView week5;
    TextView week6;
    TextView week7;
    TextView week8;
    TextView week9;
    TextView week10;
    TextView week11;
    TextView week12;
    TextView back;
    TextView vakTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weken);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        get = getIntent();
        id = get.getIntExtra("id",-1);
        procent = get.getIntExtra("procent",0);
        databaseVak = new DatabaseVak(this);

        week1 = findViewById(R.id.week1);
        week2 = findViewById(R.id.week2);
        week3 = findViewById(R.id.week3);
        week4 = findViewById(R.id.week4);
        week5 = findViewById(R.id.week5);
        week6 = findViewById(R.id.week6);
        week7 = findViewById(R.id.week7);
        week8 = findViewById(R.id.week8);
        week9 = findViewById(R.id.week9);
        week10 = findViewById(R.id.week10);
        week11 = findViewById(R.id.week11);
        week12 = findViewById(R.id.week12);
        back = findViewById(R.id.weekBack);
        vakTextview = findViewById(R.id.vakweken);

        //functions declareren
        updateTextViews();
        clickTextViewsFun();
        backfun();
        updateTextVak();
        getProcentPerWeek(id);
    }

    //functies
    public void clickTextViewsFun(){
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(1, week1);
            }
        });
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(2, week2);
            }
        });
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(3, week3);
            }
        });
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(4, week4);
            }
        });
        week5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(5, week5);
            }
        });
        week6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(6, week6);
            }
        });
        week7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(7, week7);
            }
        });
        week8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(8, week8);
            }
        });
        week9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(9, week9);
            }
        });
        week10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(10, week10);
            }
        });
        week11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(11, week11);
            }
        });
        week12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInnerFun(12, week12);
            }
        });
    }
    public void updateTextViews(){
        updateInnerFun(1,week1);
        updateInnerFun(2,week2);
        updateInnerFun(3,week3);
        updateInnerFun(4,week4);
        updateInnerFun(5,week5);
        updateInnerFun(6,week6);
        updateInnerFun(7,week7);
        updateInnerFun(8,week8);
        updateInnerFun(9,week9);
        updateInnerFun(10,week10);
        updateInnerFun(11,week11);
        updateInnerFun(12,week12);
    }
    public void clickInnerFun(final int i, TextView textView){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ObjectenLijst.class);
                intent.putExtra("week",i);
                intent.putExtra("id",id);
                intent.putExtra("procent",getProcent(i));
                startActivity(intent);
            }
        });
    }
    public void updateInnerFun(int i, TextView week){
        if (databaseVak.getWeek(id,i).equals("null")) {
            week.setText("week " + i + "");
            week.setBackgroundResource(R.drawable.colorgreybuttonsweek);
        } else if (!databaseVak.getWeek(id,i).equals("null")){
            checkIf100Procent(i);
            if (databaseVak.getWeek(id,i).equals("false")){
                if (getProcent(i) >= 0 && getProcent(i) <= 50){
                    week.setText("week "+i+" == "+getProcent(i)+"%");
                    week.setBackgroundResource(R.drawable.color1);
                } else if (getProcent(i) > 50 && getProcent(i) <= 60){
                    week.setText("week "+i+" == "+getProcent(i)+"%");
                    week.setBackgroundResource(R.drawable.color2);
                } else if (getProcent(i) > 60 && getProcent(i) <= 70){
                    week.setText("week "+i+" == "+getProcent(i)+"%");
                    week.setBackgroundResource(R.drawable.color3);
                } else if (getProcent(i) > 70 && getProcent(i) <= 80){
                    week.setText("week "+i+" == "+getProcent(i)+"%");
                    week.setBackgroundResource(R.drawable.color4);
                } else if (getProcent(i) > 80 && getProcent(i) <= 90){
                    week.setText("week "+i+" == "+getProcent(i)+"%");
                    week.setBackgroundResource(R.drawable.color5);
                }
            } else if (databaseVak.getWeek(id,i).equals("True")){
                week.setText(""+i+"  :p");
                week.setBackgroundResource(R.drawable.color6);
            }
        }
    }
    public void backfun(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkIf100Procent(int i){
        if (getProcent(i)!= 100){
            databaseVak.updateFalse(i,id);
        }   else {
                if (getProcent(i)== 100){
                    databaseVak.updateTrue(i,id);
                }
            }
    }

    public void updateTextVak(){
        String vak = databaseVak.getNaamLes(id);
        vakTextview.setText(vak);
    }

    public int getProcent(int i){
        int out = 0;
        if (!databaseVak.getTotalPercentage(id,i).equals("")){
            out = Integer.parseInt(databaseVak.getTotalPercentage(id,i))/databaseVak.getGrote(id,i);
        }
        return out;
    }

    public void getProcentPerWeek(int id){
        int uitkomst = procent;
        ConstraintLayout og = (ConstraintLayout) findViewById(R.id.ogConstraintLayoutWeken);
        if (uitkomst > 1 && uitkomst <= 50) {
            og.setBackground(getResources().getDrawable(R.drawable.background1));
        } else if (uitkomst > 50 && uitkomst <= 60){
            og.setBackground(getResources().getDrawable(R.drawable.background2));
        }else if (uitkomst > 60 && uitkomst <= 70){
            og.setBackground(getResources().getDrawable(R.drawable.background3));
        }else if (uitkomst > 70 && uitkomst <= 80){
            og.setBackground(getResources().getDrawable(R.drawable.background4));
        }else if (uitkomst > 80 && uitkomst <= 90){
            og.setBackground(getResources().getDrawable(R.drawable.background5));
        }else if (uitkomst > 90 && uitkomst <= 100){
            og.setBackground(getResources().getDrawable(R.drawable.background6));
        }
    }
}