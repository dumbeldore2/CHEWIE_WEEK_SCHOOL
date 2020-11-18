package com.example.chewie_week_school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
    DatabaseVak databaseVak;
    ListView listView;
    Button addToListview;
    Intent get;
    int id = 0;
    int week = 0;
    int procent = 0;
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

        databaseVak = new DatabaseVak(this);
        listView = findViewById(R.id.listviewObjecten);
        addToListview = findViewById(R.id.addToListview);
        get = getIntent();
        id = get.getIntExtra("id", -1);
        week = get.getIntExtra("week", -1);
        procent = get.getIntExtra("procent", 0);
        lijst = new ArrayList<>();
        back = findViewById(R.id.backToListview);
        vakTextview = findViewById(R.id.vakObjectLijst);
        weekTextview = findViewById(R.id.weekObjectLijst);

        //function
        buttonFun();
        lijstUpdaten();
        backButton();
        CheckIfEmpty();
        weekTextviewfun();
        getProcentPerWeek();

    }

    public void buttonFun(){
        addToListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ObjectenAdd.class);
                intent.putExtra("id",id);
                intent.putExtra("week",week);
                intent.putExtra("procent",procent);
                startActivity(intent);
            }
        });
    }

    public void lijstUpdaten(){
        lijst = databaseVak.berichten(id,week);
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
                intent.putExtra("procent", getProcent(week));
                startActivity(intent);
            }
        });
    }

    public int getProcent(int i){
        return Integer.parseInt(databaseVak.getTotalPercentage(id,i))/databaseVak.getGrote(id,i);
    }

    public void veranderPercentage(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if (Integer.parseInt(databaseVak.getPercent(id, week, pos)) == 0) {
                    databaseVak.updateTo50(Integer.parseInt(databaseVak.getPercentID(id, week, pos)), id, week);
                    lijstUpdaten();
                }   else {
                        if (Integer.parseInt(databaseVak.getPercent(id, week, pos)) == 50) {
                            databaseVak.updateTo100(Integer.parseInt(databaseVak.getPercentID(id, week, pos)), id, week);
                            lijstUpdaten();
                        }       else {
                                    if (Integer.parseInt(databaseVak.getPercent(id, week, pos)) == 100) {
                                        databaseVak.updateTo0(Integer.parseInt(databaseVak.getPercentID(id, week, pos)), id, week);
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

    public String getFirst(){
        String out = "";
        out = lijst.get(0);
        return out;
    }

    public void CheckIfEmpty(){
        if (!getFirst().equals("er is nog geen informatie")){
            veranderPercentage();
        }
    }


    public void getProcentPerWeek(){
        int uitkomst = procent;
        ConstraintLayout og = (ConstraintLayout) findViewById(R.id.ogConstraintLayoutObjectenLijst);
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
