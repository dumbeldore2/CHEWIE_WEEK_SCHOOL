package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ObjectenAdd extends AppCompatActivity {
    EditText editText ;
    Button back;
    Button add;
    DatabaseVak databaseVak;
    Intent get;
    int id = 0;
    int week = 0;
    int procent = 0;
    TextView vakTextview;
    TextView weekTextview;
    TextView errorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objecten_add);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        editText = findViewById(R.id.editTextToevoegenObject);
        back = findViewById(R.id.backToevoegenObject);
        add = findViewById(R.id.addToevoegenObject);
        databaseVak = new DatabaseVak(this);
        get = getIntent();
        id = get.getIntExtra("id",-1);
        week = get.getIntExtra("week",-1);
        procent = get.getIntExtra("procent",0);
        vakTextview = findViewById(R.id.vakObjectadd);
        weekTextview = findViewById(R.id.weekObjectadd);
        errorMessage = findViewById(R.id.errorMessageAddObject);

        backFun();
        addFun();
        weekTextviewfun();
        getProcentPerWeek();
    }

    public String getEditText(){
        String uit = "";
        if (editText.getText().toString().trim() != null){
            uit = editText.getText().toString();
        }
        return  uit;
    }

    public void backFun(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ObjectenLijst.class);
                intent.putExtra("id",id);
                intent.putExtra("week",week);
                intent.putExtra("procent" ,procent);
                startActivity(intent);
            }
        });
    }

    public void addFun(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getEditText() != null && !getEditText().isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),ObjectenLijst.class);
                    databaseVak.insertObjectTable1(id,getEditText(),week);
                    intent.putExtra("id",id);
                    intent.putExtra("week",week);
                    intent.putExtra("procent" ,procent);
                    databaseVak.updateFalse(week,id);
                    startActivity(intent);
                } else {
                    errorMessage.setText("cant be empty");
                }
            }
        });
    }
    public void weekTextviewfun(){
        String vak = databaseVak.getNaamLes(id);
        String weektext = " week " + week;

        vakTextview.setText(vak);
        weekTextview.setText(weektext);
    }

    public void getProcentPerWeek(){
        int uitkomst = procent;
        ConstraintLayout og = (ConstraintLayout) findViewById(R.id.ogConstraintLayoutObjectenAdd);
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