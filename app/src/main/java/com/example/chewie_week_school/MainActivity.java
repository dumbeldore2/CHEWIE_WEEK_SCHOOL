package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //atributen
    ListView listViewLes;
    Button addLes;
    Button verwijderLes;
    ArrayList<String>lessen;
    DatabaseVak databaseVak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variabelen declaratie
        listViewLes = findViewById(R.id.lisTviewles);
        addLes = findViewById(R.id.addLesButton);
        verwijderLes = findViewById(R.id.verwijderLesButton);
        lessen = new ArrayList<>();
        databaseVak = new DatabaseVak(this);

        //functies declaren
        addLesFun();
        setListViewLes();
        clickOnListView();
    }

    public void addLesFun(){
        addLes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VoegToe.class);
                startActivity(intent);
            }
        });
    }

    public void setListViewLes() {
        lessen = databaseVak.getLessen();
        listViewLes.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,lessen));
    }

    public void clickOnListView(){
        listViewLes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Weken.class);
                intent.putExtra("id",i);
                System.out.println(i);
                startActivity(intent);
            }
        });
    }
}