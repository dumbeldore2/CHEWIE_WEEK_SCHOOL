package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Weken extends AppCompatActivity {
    ListView listView;
    ArrayList arrayList;
    Intent get;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weken);

        listView = findViewById(R.id.lisTviewWeken);
        arrayList = new ArrayList();
        arrayList.add("week 1");
        arrayList.add("week 2");
        arrayList.add("week 3");
        arrayList.add("week 4");
        arrayList.add("week 5");
        arrayList.add("week 6");
        arrayList.add("week 7");
        arrayList.add("week 8");
        arrayList.add("week 9");
        arrayList.add("week 10");
        arrayList.add("week 11");
        arrayList.add("week 12");
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList));
        get = getIntent();
        id = get.getIntExtra("id",-1);
        System.out.println(id);

        //functions declareren

    }
}