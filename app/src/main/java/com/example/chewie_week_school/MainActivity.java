package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

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
    TextView errorbericht;


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
                    Intent intent = new Intent(getApplicationContext(), ToevoegenLes.class);
                    intent.putExtra("id",0);
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(0).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(0).equals("null")){
                                Intent intent = new Intent(getApplicationContext(),Weken.class);
                                intent.putExtra("id",0);
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
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(1).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(1).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 1);
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
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(2).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(2).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 2);
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
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(3).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(3).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 3);
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
                    startActivity(intent);
                }else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(4).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(4).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
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
                    startActivity(intent);
                } else {
                    if (aangeklikt == 0){
                        if (databaseVak.getNaamLes(5).equals("null")){
                            errorfun();
                        } else {
                            if (!databaseVak.getNaamLes(5).equals("null")) {
                                Intent intent = new Intent(getApplicationContext(), Weken.class);
                                intent.putExtra("id", 5);
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
        if (!databaseVak.isErEenFalse(id)){
            button.setBackgroundResource(R.drawable.colorgreenmain);
        }
        if (databaseVak.isErEenFalse(id)){
            button.setBackgroundResource(R.drawable.colorredmain);
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
}