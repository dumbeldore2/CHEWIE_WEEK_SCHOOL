package com.example.chewie_week_school;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseObjecten extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "object.db";
    public static final String DATABASE_TABLE = "object";
    public static final String COL_1 = "id";
    public static final String COL_2 = "datum";
    public static final String COL_3 = "lesid";
    public static final String COL_4 = "bericht";
    public static final String COL_5 = "week";
    public static final String COL_6 = "percent";

    public DatabaseObjecten(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE + " (id INTEGER primary key,datum text, les INTEGER , bericht text,week text, percent INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
    public int IDMAKER() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from objecten", null
        );
        return cursor.getCount();
    }

    public void insertObject(int lesid, String bericht ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Date calender = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.FULL).format(calender);

        contentValues.put(COL_1, IDMAKER());
        contentValues.put(COL_2, deDatum);
        contentValues.put(COL_3, lesid);
        contentValues.put(COL_4, bericht);
        contentValues.put(COL_5,0);
        sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public Boolean erIsDataVanDieWeekEnDieLes(int id,int iweek) {
        boolean uit = false;
        Cursor cursor = getWritableDatabase().rawQuery("select * from objecten where lesid == " + id + " and week == " + iweek, null);
        if (cursor.getCount() > 0) {
            uit = true;
        }
        return uit;
    }
}
