package com.example.chewie_week_school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Weken extends AppCompatActivity {
    ListView listView;
    ArrayList arrayList;
    Intent get;
    int id;
    DatabaseVak databaseVak;
    TextView week1;
    TextView week2;
    TextView week3;
    TextView week4;
    TextView week5;
    TextView week6;
    TextView week7;
    TextView week8;
    TextView week9;
    TextView week10;
    TextView week11;
    TextView week12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weken);

        get = getIntent();
        id = get.getIntExtra("id",-1);
        databaseVak = new DatabaseVak(this);

        week1 = findViewById(R.id.week1);
        week2 = findViewById(R.id.week2);
        week3 = findViewById(R.id.week3);
        week4 = findViewById(R.id.week4);
        week5 = findViewById(R.id.week5);
        week6 = findViewById(R.id.week6);
        week7 = findViewById(R.id.week7);
        week8 = findViewById(R.id.week8);
        week9 = findViewById(R.id.week9);
        week10 = findViewById(R.id.week10);
        week11 = findViewById(R.id.week11);
        week12 = findViewById(R.id.week12);


        //functions declareren
        updateTextViews();
        clickTextViewsFun();
    }

    //functies
    public void clickTextViewsFun(){
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,1).equals("null")){
                    databaseVak.updateFalse(1,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,1).equals("True")){
                    databaseVak.updateFalse(1,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,1).equals("false")){
                    databaseVak.updateTrue(1,id);
                    updateTextViews();
                }
            }
        });
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,2).equals("null")){
                    databaseVak.updateFalse(2,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,2).equals("True")){
                    databaseVak.updateFalse(2,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,2).equals("false")){
                    databaseVak.updateTrue(2,id);
                    updateTextViews();
                }
            }
        });
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,3).equals("null")){
                    databaseVak.updateFalse(3,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,3).equals("True")){
                    databaseVak.updateFalse(3,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,3).equals("false")){
                    databaseVak.updateTrue(3,id);
                    updateTextViews();
                }
            }
        });
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,4).equals("null")){
                    databaseVak.updateFalse(4,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,4).equals("True")){
                    databaseVak.updateFalse(4,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,4).equals("false")){
                    databaseVak.updateTrue(4,id);
                    updateTextViews();
                }
            }
        });
        week5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,5).equals("null")){
                    databaseVak.updateFalse(5,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,5).equals("True")){
                    databaseVak.updateFalse(5,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,5).equals("false")){
                    databaseVak.updateTrue(5,id);
                    updateTextViews();
                }
            }
        });
        week6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,6).equals("null")){
                    databaseVak.updateFalse(6,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,6).equals("True")){
                    databaseVak.updateFalse(6,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,6).equals("false")){
                    databaseVak.updateTrue(6,id);
                    updateTextViews();
                }
            }
        });

        week7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,7).equals("null")){
                    databaseVak.updateFalse(7,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,7).equals("True")){
                    databaseVak.updateFalse(7,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,7).equals("false")){
                    databaseVak.updateTrue(7,id);
                    updateTextViews();
                }
            }
        });
        week8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,8).equals("null")){
                    databaseVak.updateFalse(8,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,8).equals("True")){
                    databaseVak.updateFalse(8,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,8).equals("false")){
                    databaseVak.updateTrue(8,id);
                    updateTextViews();
                }
            }
        });

        week9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,9).equals("null")){
                    databaseVak.updateFalse(9,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,9).equals("True")){
                    databaseVak.updateFalse(9,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,9).equals("false")){
                    databaseVak.updateTrue(9,id);
                    updateTextViews();
                }
            }
        });
        week10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,10).equals("null")){
                    databaseVak.updateFalse(10,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,10).equals("True")){
                    databaseVak.updateFalse(10,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,10).equals("false")){
                    databaseVak.updateTrue(10,id);
                    updateTextViews();
                }
            }
        });
        week11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,11).equals("null")){
                    databaseVak.updateFalse(11,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,11).equals("True")){
                    databaseVak.updateFalse(11,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,11).equals("false")){
                    databaseVak.updateTrue(11,id);
                    updateTextViews();
                }
            }
        });
        week12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseVak.getWeek(id,12).equals("null")){
                    databaseVak.updateFalse(12,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,12).equals("True")){
                    databaseVak.updateFalse(12,id);
                    updateTextViews();
                } else if (databaseVak.getWeek(id,12).equals("false")){
                    databaseVak.updateTrue(12,id);
                    updateTextViews();
                }
            }
        });
    }
    public void updateTextViews(){
        if (databaseVak.getWeek(id,1).equals("null")){
            week1.setText("week 1 nog niet af");
            week1.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,1).equals("false")){
            week1.setText("week 1 nog niet af");
            week1.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,1).equals("True")){
            week1.setText("week 1 is FINISHED");
            week1.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,2).equals("null")){
            week2.setText("week 2 nog niet af");
            week2.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,2).equals("false")){
            week2.setText("week 2 nog niet af");
            week2.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,2).equals("True")){
            week2.setText("week 2 is FINISHED");
            week2.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,3).equals("null")){
            week3.setText("week 3 nog niet af");
            week3.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,3).equals("false")){
            week3.setText("week 3 nog niet af");
            week3.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,3).equals("True")){
            week3.setText("week 3 is FINISHED");
            week3.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,4).equals("null")){
            week4.setText("week 4 nog niet af");
            week4.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,4).equals("false")){
            week4.setText("week 4 nog niet af");
            week4.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,4).equals("True")){
            week4.setText("week 4 is FINISHED");
            week4.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,5).equals("null")){
            week5.setText("week 5 nog niet af");
            week5.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,5).equals("false")){
            week5.setText("week 5 nog niet af");
            week5.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,5).equals("True")){
            week5.setText("week 5 is FINISHED");
            week5.setBackgroundResource(R.drawable.colorgreen);
        }


        if (databaseVak.getWeek(id,6).equals("null")){
            week6.setText("week 6 nog niet af");
            week6.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,6).equals("false")){
            week6.setText("week 6 nog niet af");
            week6.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,6).equals("True")){
            week6.setText("week 6 is FINISHED");
            week6.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,7).equals("null")){
            week7.setText("week 7 nog niet af");
            week7.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,7).equals("false")){
            week7.setText("week 7 nog niet af");
            week7.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,7).equals("True")){
            week7.setText("week 7 is FINISHED");
            week7.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,8).equals("null")){
            week8.setText("week 8 nog niet af");
            week8.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,8).equals("false")){
            week8.setText("week 8 nog niet af");
            week8.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,8).equals("True")){
            week8.setText("week 8 is FINISHED");
            week8.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,9).equals("null")){
            week9.setText("week 9 nog niet af");
            week9.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,9).equals("false")){
            week9.setText("week 9 nog niet af");
            week9.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,9).equals("True")){
            week9.setText("week 9 is FINISHED");
            week9.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,10).equals("null")){
            week10.setText("week 10 nog niet af");
            week10.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,10).equals("false")){
            week10.setText("week 10 nog niet af");
            week10.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,10).equals("True")){
            week10.setText("week 10 is FINISHED");
            week10.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,11).equals("null")){
            week11.setText("week 11 nog niet af");
            week11.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,11).equals("false")){
            week11.setText("week 11 nog niet af");
            week11.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,11).equals("True")){
            week11.setText("week 11 is FINISHED");
            week11.setBackgroundResource(R.drawable.colorgreen);
        }

        if (databaseVak.getWeek(id,12).equals("null")){
            week12.setText("week 12 nog niet af");
            week12.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,12).equals("false")){
            week12.setText("week 12 nog niet af");
            week12.setBackgroundResource(R.drawable.colorred);
        } else if (databaseVak.getWeek(id,12).equals("True")){
            week12.setText("week 12 is FINISHED");
            week12.setBackgroundResource(R.drawable.colorgreen);

        }




    }
}