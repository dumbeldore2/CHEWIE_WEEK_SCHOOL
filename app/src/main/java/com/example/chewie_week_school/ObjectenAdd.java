package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

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
    DatabaseObjecten databaseObjecten;
    DatabaseVak databaseVak;
    Intent get;
    int id = 0;
    int week = 0;
    TextView vakTextview;
    TextView weekTextview;


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
        databaseObjecten = new DatabaseObjecten(this);
        databaseVak = new DatabaseVak(this);
        get = getIntent();
        id = get.getIntExtra("id",-1);
        week = get.getIntExtra("week",-1);
        vakTextview = findViewById(R.id.vakObjectadd);
        weekTextview = findViewById(R.id.weekObjectadd);

        backFun();
        addFun();
        weekTextviewfun();
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
                    databaseObjecten.insertObject(id,getEditText(),week);
                    intent.putExtra("id",id);
                    intent.putExtra("week",week);
                    databaseVak.updateFalse(week,id);
                    startActivity(intent);
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
}