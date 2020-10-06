package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ObjectenLijst extends AppCompatActivity {

    DatabaseObjecten databaseObjecten;
    ListView listView;
    Button addToListview;
    Intent get;
    int id = 0;
    int week = 0;
    ArrayList<String>lijst;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objecten_lijst);

        databaseObjecten = new DatabaseObjecten(this);
        listView = findViewById(R.id.listviewObjecten);
        addToListview = findViewById(R.id.addToListview);
        get = getIntent();
        id = get.getIntExtra("id", -1);
        week = get.getIntExtra("week", -1);
        lijst = new ArrayList<>();
        back = findViewById(R.id.backToListview);
        buttonFun();
        lijstUpdaten();
        backButton();

    }

    public void buttonFun(){
        addToListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ObjectenAdd.class);
                intent.putExtra("id",id);
                intent.putExtra("week",week);
                startActivity(intent);
            }
        });
    }

    public void lijstUpdaten(){
        lijst = databaseObjecten.berichten(id,week);
        if (lijst.size() == 0){
            lijst.add("er is nog geen informatie");
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lijst);
            listView.setAdapter(arrayAdapter);
        } else {
            if (lijst.size()>0){
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lijst);
                listView.setAdapter(arrayAdapter);
            }
        }
    }

    public void backButton(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Weken.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}