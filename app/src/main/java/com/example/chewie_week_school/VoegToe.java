package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VoegToe extends AppCompatActivity {
    //variabelen
    EditText les;
    EditText semester;
    TextView add;
    DatabaseVak databaseVak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voeg_toe);
        //variabelen declareren
        les = findViewById(R.id.les);
        semester = findViewById(R.id.semester);
        add = findViewById(R.id.addDeShit);
        databaseVak = new DatabaseVak(this);


        //functies declaren
        addFun();
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
                databaseVak.insertFoodObject(getLes(),getSemester());
                Intent intent = new Intent(getApplicationContext(), Weken.class);
                startActivity(intent);
            }
        });
    }

}