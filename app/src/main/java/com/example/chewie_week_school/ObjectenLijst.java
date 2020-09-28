package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ObjectenLijst extends AppCompatActivity {

    DatabaseObjecten databaseObjecten;
    ListView listView;
    Button addToListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objecten_lijst);

        databaseObjecten = new DatabaseObjecten(this);
        listView = findViewById(R.id.listviewObjecten);
        addToListview = findViewById(R.id.addToListview);

        buttonFun();
    }

    public void buttonFun(){
        addToListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ObjectenAdd.class);
                startActivity(intent);
            }
        });
    }
}