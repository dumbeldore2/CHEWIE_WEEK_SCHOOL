package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

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
    int procent;
    TextView errorbericht;
    TextView vak1textview;
    TextView vak2textview;
    TextView vak3textview;
    TextView vak4textview;
    TextView vak5textview;
    TextView vak6textview;
    ArrayList<String>weken;


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
        errorbericht = findViewById(R.id.errorMessage);
        vak1textview = findViewById(R.id.vak1Text);
        vak2textview = findViewById(R.id.vak2Text);
        vak3textview = findViewById(R.id.vak3Text);
        vak4textview = findViewById(R.id.vak4Text);
        vak5textview = findViewById(R.id.vak5Text);
        vak6textview = findViewById(R.id.vak6Text);
        weken = new ArrayList<>();

        //functies declaren
        databaseVak.insertZesVaken();
        updateButtons();
        clickOnListView();
        changeFun();
        changeTextview();
        backgroundFun();

        //testArea
        ArrayList<String>nummers = new ArrayList<>();
        nummers = databaseVak.ids(1);
        for (int i = 0 ; i < nummers.size();i++){
            System.out.println(nummers.get(i));
        }
    }

    public void clickOnListView(){
        vak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",0);
                    intent.putExtra("procent", nummerBackground());
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(0).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(0).equals("null")){
                                Intent intent = new Intent(getApplicationContext(),Weken.class);
                                intent.putExtra("id",0);
                                intent.putExtra("procent", getProcentPerWeek(0));
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
        vak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",1);
                    intent.putExtra("procent", nummerBackground());
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(1).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(1).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 1);
                                intent.putExtra("procent", getProcentPerWeek(1));
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
        vak3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",2);
                    intent.putExtra("procent", nummerBackground());
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(2).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(2).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 2);
                                intent.putExtra("procent", getProcentPerWeek(2));
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
        vak4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",3);
                    intent.putExtra("procent", nummerBackground());
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(3).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(3).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 3);
                                intent.putExtra("procent", getProcentPerWeek(3));
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
        vak5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",4);
                    intent.putExtra("procent", nummerBackground());
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(4).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(4).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("procent", getProcentPerWeek(4));
                                intent.putExtra("id", 4);
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
        vak6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aangeklikt == 1){
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",5);
                    intent.putExtra("procent", nummerBackground());
                    startActivity(intent);
                } else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(5).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(5).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 5);
                                intent.putExtra("procent", getProcentPerWeek(5));
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
    }
    public void updateButtons(){
        updateInnerFun(vak1,0);
        updateInnerFun(vak2,1);
        updateInnerFun(vak3,2);
        updateInnerFun(vak4,3);
        updateInnerFun(vak5,4);
        updateInnerFun(vak6,5);
    }

    public void updateInnerFun(Button button, int id){
        if (getProcentPerWeek(id) >=0 && getProcentPerWeek(id) <=50){
            button.setBackgroundResource(R.drawable.color1main);
        } else if (getProcentPerWeek(id) >50 && getProcentPerWeek(id) <=60) {
            button.setBackgroundResource(R.drawable.color2main);
        } else if (getProcentPerWeek(id) >60 && getProcentPerWeek(id) <=70) {
            button.setBackgroundResource(R.drawable.color3main);
        } else if (getProcentPerWeek(id) >70 && getProcentPerWeek(id) <=80) {
            button.setBackgroundResource(R.drawable.color4main);
        } else if (getProcentPerWeek(id) >80 && getProcentPerWeek(id) <=90) {
            button.setBackgroundResource(R.drawable.color5main);
        } else if (getProcentPerWeek(id) >90 && getProcentPerWeek(id) <=100) {
            button.setBackgroundResource(R.drawable.color6main);
        }
        button.setText(databaseVak.getLetters(id));
    }

    public void changeFun(){
        addLes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    public void errorfun(){
        errorbericht.setText("druk eerst op de change button en dan op de gewenste bol");
    }

    public int getProcentPerWeek(int id){
        int aantal = 0;
        int nummers = 0;
        for (int i = 1; i < 12;i++){
            if (!databaseVak.getWeek(id,i).equals("null")){
                aantal += Integer.parseInt(databaseVak.getTotalPercentage(id,i))/databaseVak.getGrote(id,i);
                nummers ++;
            }
        }
        if (aantal == 0){
            aantal = 1;
        }
        if (nummers == 0){
            nummers = 1;
        }
        return (aantal/nummers);
    }

    public void changeTextview(){
        if (!databaseVak.getNaamLes(0).equals("null")){
            vak1textview.setText(databaseVak.getNaamLes(0) + " : " + getProcentPerWeek(0) + "%");
        } else {
            vak1textview.setText("");
        }
        if (!databaseVak.getNaamLes(1).equals("null")){
            vak2textview.setText(databaseVak.getNaamLes(1) + " : " + getProcentPerWeek(1) + "%");
        } else {
            vak2textview.setText("");
        }
        if (!databaseVak.getNaamLes(2).equals("null")){
            vak3textview.setText(databaseVak.getNaamLes(2) + " : " + getProcentPerWeek(2) + "%");
        } else {
            vak3textview.setText("");
        }
        if (!databaseVak.getNaamLes(3).equals("null")){
            vak4textview.setText(databaseVak.getNaamLes(3) + " : " + getProcentPerWeek(3) + "%");
        } else {
            vak4textview.setText("");
        }
        if (!databaseVak.getNaamLes(4).equals("null")){
            vak5textview.setText(databaseVak.getNaamLes(4) + " : " + getProcentPerWeek(4) + "%");
        } else {
            vak5textview.setText("");
        }
        if (!databaseVak.getNaamLes(5).equals("null")){
            vak6textview.setText(databaseVak.getNaamLes(5) + " : " + getProcentPerWeek(5) + "%");
        } else {
            vak6textview.setText("");
        }
    }

    public void backgroundFun(){
        ConstraintLayout og = (ConstraintLayout) findViewById(R.id.ogConstraintLayoutMainActivity);
        if (nummerBackground() > 1 && nummerBackground() <= 50) {
            og.setBackground(getResources().getDrawable(R.drawable.background1));
        } else if (nummerBackground() > 50 && nummerBackground() <= 60){
            og.setBackground(getResources().getDrawable(R.drawable.background2));
        }else if (nummerBackground() > 60 && nummerBackground() <= 70){
            og.setBackground(getResources().getDrawable(R.drawable.background3));
        }else if (nummerBackground() > 70 && nummerBackground() <= 80){
            og.setBackground(getResources().getDrawable(R.drawable.background4));
        }else if (nummerBackground() > 80 && nummerBackground() <= 90){
            og.setBackground(getResources().getDrawable(R.drawable.background5));
        }else if (nummerBackground() > 90 && nummerBackground() <= 100){
            og.setBackground(getResources().getDrawable(R.drawable.background6));
        }
    }

    public int nummerBackground(){
        int nummer = 0;
        int aantal = 0;
        for (int i = 0;i < 6 && !databaseVak.getNaamLes(i).equals("null") ; i++){
            nummer += getProcentPerWeek(i);
            aantal++;
        }
        if (nummer == 0){
            nummer =1;
        }
        if (aantal == 0){
            aantal =1;
        }
        return nummer/aantal;
    }
}