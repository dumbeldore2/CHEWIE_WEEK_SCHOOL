package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class ToevoegenLes extends AppCompatActivity {
    //variabelen
    EditText les;
    EditText semester;
    TextView add;
    TextView back;
    DatabaseVak databaseVak;
    int id;
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
        databaseVak = new DatabaseVak(this);
        get = getIntent();
        id = get.getIntExtra("id",-1) - 1;



        //functies declaren
        addFun();
        backFun();
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
                databaseVak.updateVak(id,getLes(),getSemester());
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
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
}