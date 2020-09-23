package com.example.chewie_week_school;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DatabaseVak extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "vakken.db";
    public static final String DATABASE_TABLE = "vakken";
    public static final String COL_1 = "id";
    public static final String COL_2 = "naam";
    public static final String COL_3 = "datum";
    public static final String COL_4 = "semester";
    public static final String COL_5 = "week1";
    public static final String COL_6 = "week2";
    public static final String COL_7 = "week3";
    public static final String COL_8 = "week4";
    public static final String COL_9 = "week5";
    public static final String COL_10 = "week6";
    public static final String COL_11 = "week7";
    public static final String COL_12 = "week8";
    public static final String COL_13 = "week9";
    public static final String COL_14 = "week10";
    public static final String COL_15 = "week11";
    public static final String COL_16 = "week12";

    public DatabaseVak(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE + " (id INTEGER primary key,naam text, datum " +
                "text, semester INTEGER," +
                "week1 text,week2 text,week3 text,week4 text,week5 text," +
                "week6 text,week7 text,week8 text,week9 text,week10 text," +
                "week11 text,week12 text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public  int IDMAKER(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from vakken",null
        );
        return cursor.getCount();
    }

    public void insertFoodObject(String les, int semester){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Date calender = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.FULL).format(calender);

        contentValues.put(COL_1,IDMAKER());
        contentValues.put(COL_2,les);
        contentValues.put(COL_3,deDatum);
        contentValues.put(COL_4,semester);
        contentValues.put(COL_5,"null");
        contentValues.put(COL_6,"null");
        contentValues.put(COL_7,"null");
        contentValues.put(COL_8,"null");
        contentValues.put(COL_9,"null");
        contentValues.put(COL_10,"null");
        contentValues.put(COL_11,"null");
        contentValues.put(COL_12,"null");
        contentValues.put(COL_13,"null");
        contentValues.put(COL_14,"null");
        contentValues.put(COL_15,"null");
        contentValues.put(COL_16,"null");
        sqLiteDatabase.insert(DATABASE_TABLE, null,contentValues);
    }

    public String getNaamLes(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select naam from vakken where id == " + id,null);
        if (cursor.moveToFirst()){
            stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString();
    }
    public ArrayList<String>getLessen(){
        ArrayList<String>uit;
        uit = new ArrayList<>();

        for (int i = 0; i < IDMAKER() ; i++){
            uit.add(getNaamLes(i));
        }
        return uit;
    }
}
