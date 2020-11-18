package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ToevoegenLes extends AppCompatActivity {
    //variabelen
    EditText les;
    EditText semester;
    TextView add;
    TextView back;
    TextView error;
    DatabaseVak databaseVak;
    int id;
    int procent;
    Intent get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voeg_toe);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        //variabelen declareren
        les = findViewById(R.id.les);
        semester = findViewById(R.id.semester);
        add = findViewById(R.id.addDeShit);
        back = findViewById(R.id.backVoegToe);
        error = findViewById(R.id.errorMessageAddLes);
        databaseVak = new DatabaseVak(this);
        get = getIntent();
        id = get.getIntExtra("id",-1);
        procent = get.getIntExtra("procent",0);



        //functies declaren
        addFun();
        backFun();
        backgroundFun();
    }

    public String getLes(){
        if (les.getText().toString().trim().isEmpty() || les.getText() == null)throw new IllegalArgumentException("lolll tis kapot");
        return les.getText().toString().trim();
    }
    public int getSemester(){
        if (Integer.parseInt(semester.getText().toString().trim()) < 1 || Integer.parseInt(semester.getText().toString().trim())>3)throw new IllegalArgumentException("lolll tis kapot");
        return Integer.parseInt(semester.getText().toString().trim());
    }
    public void addFun(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!les.getText().toString().trim().isEmpty() && les.getText() != null){
                    if (!semester.getText().toString().isEmpty() && Integer.parseInt(semester.getText().toString()) > 0 && Integer.parseInt(semester.getText().toString()) < 4){
                        databaseVak.updateVak(id,getLes(),getSemester());
                        ArrayList<String>cijfers = new ArrayList<>();
                        cijfers = databaseVak.ids(id);
                        for (int i = 0 ; i < cijfers.size() ; i++){
                            databaseVak.delete(Integer.parseInt(cijfers.get(i)));
                        }
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    } else {
                        ErrorFun("er is een probleem met het semester");
                    }
                } else {
                    ErrorFun("les is leeg");
                }
            }
        });
    }
    public void backFun(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ErrorFun(String message){
        error.setText(message);
    }

    public void backgroundFun(){
        int uitkomst = procent;
        ConstraintLayout og = (ConstraintLayout) findViewById(R.id.ogConstraintLayoutVoegToeLes);
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