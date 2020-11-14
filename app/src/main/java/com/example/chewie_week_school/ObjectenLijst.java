package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ObjectenLijst extends AppCompatActivity {

    DatabaseObjecten databaseObjecten;
    DatabaseVak databaseVak;
    ListView listView;
    Button addToListview;
    Intent get;
    int id = 0;
    int week = 0;
    ArrayList<String>lijst;
    Button back;
    TextView vakTextview;
    TextView weekTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objecten_lijst);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        databaseObjecten = new DatabaseObjecten(this);
        databaseVak = new DatabaseVak(this);
        listView = findViewById(R.id.listviewObjecten);
        addToListview = findViewById(R.id.addToListview);
        get = getIntent();
        id = get.getIntExtra("id", -1);
        week = get.getIntExtra("week", -1);
        lijst = new ArrayList<>();
        back = findViewById(R.id.backToListview);
        vakTextview = findViewById(R.id.vakObjectLijst);
        weekTextview = findViewById(R.id.weekObjectLijst);

        //function
        buttonFun();
        lijstUpdaten();
        backButton();
        veranderPercentage();
        weekTextviewfun();

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
        System.out.println(lijst.size());
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


    public void veranderPercentage(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if (Integer.parseInt(databaseObjecten.getPercent(id, week, pos)) == 0) {
                    databaseObjecten.updateTo50(Integer.parseInt(databaseObjecten.getPercentID(id, week, pos)), id, week);
                    lijstUpdaten();
                }   else {
                        if (Integer.parseInt(databaseObjecten.getPercent(id, week, pos)) == 50) {
                            databaseObjecten.updateTo100(Integer.parseInt(databaseObjecten.getPercentID(id, week, pos)), id, week);
                            lijstUpdaten();
                        }       else {
                                    if (Integer.parseInt(databaseObjecten.getPercent(id, week, pos)) == 100) {
                                        databaseObjecten.updateTo0(Integer.parseInt(databaseObjecten.getPercentID(id, week, pos)), id, week);
                                        lijstUpdaten();
                                    }
                                }
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
