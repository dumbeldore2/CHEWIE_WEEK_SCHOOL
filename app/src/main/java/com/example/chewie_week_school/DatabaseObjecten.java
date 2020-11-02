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
        db.execSQL("create table " + DATABASE_TABLE + " (id INTEGER primary key,datum text,lesid INTEGER, bericht text,week INTEGER,percent INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
    public int IDMAKER() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from object", null
        );
        return cursor.getCount();
    }

    public void insertObject(int lesid, String bericht,int weekid){
        System.out.println(weekid+"cum");
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Date calender = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.FULL).format(calender);

        contentValues.put(COL_1, IDMAKER());
        contentValues.put(COL_2, deDatum);
        contentValues.put(COL_3, lesid);
        contentValues.put(COL_4, bericht);
        contentValues.put(COL_5, weekid);
        contentValues.put(COL_6,0);
        sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public Integer geefAantalDataVanDieWeek(int id,int iweek) {
        int uit = -1;
        Cursor cursor = getWritableDatabase().rawQuery("select * from object where lesid == " + id + " and week == " + iweek, null);
        uit = cursor.getCount();
        return uit;
    }
    public Boolean erIsAlInfo(int id,int iweek) {
        int uit = -1;
        Cursor cursor = getWritableDatabase().rawQuery("select * from object where lesid == " + id + " and week == " + iweek, null);
        uit = cursor.getCount();
        if (uit > 0){
            return true;
        } else {
            return false;
        }
    }

    public String bericht(int lesid,int weekid,int pos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select bericht from object where lesid == " + lesid + " and week == "+ weekid, null);
        if (cursor.moveToPosition(pos)){
        stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString().trim();
    }
    public String getPercent(int lesid,int weekid,int pos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        if (erIsAlInfo(lesid,weekid)){
            Cursor cursor = sqLiteDatabase.rawQuery("select percent from object where lesid == " + lesid + " and week == "+ weekid, null);
            if (cursor.moveToPosition(pos)){
                stringBuffer.append(cursor.getString(0));
            }
        }
        return stringBuffer.toString().trim();
    }

    public ArrayList<String> berichten(int id , int week){
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (int i = 0 ; i < geefAantalDataVanDieWeek(id,week);i++){
            arrayList.add(bericht(id,week,i));
        }
        return arrayList;
    }

}
