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
    public static final String DATABASE_TABLE0 = "vakken";
    public static final String DATABASE_TABLE1 = "object";
    public static final String COL_0_1 = "id";
    public static final String COL_0_2 = "naam";
    public static final String COL_0_3 = "datum";
    public static final String COL_0_4 = "semester";
    public static final String COL_0_5 = "week1";
    public static final String COL_0_6 = "week2";
    public static final String COL_0_7 = "week3";
    public static final String COL_0_8 = "week4";
    public static final String COL_0_9 = "week5";
    public static final String COL_0_10 = "week6";
    public static final String COL_0_11 = "week7";
    public static final String COL_0_12 = "week8";
    public static final String COL_0_13 = "week9";
    public static final String COL_0_14 = "week10";
    public static final String COL_0_15 = "week11";
    public static final String COL_0_16 = "week12";
    public static final String COL_1_1 = "id";
    public static final String COL_1_2 = "datum";
    public static final String COL_1_3 = "lesid";
    public static final String COL_1_4 = "bericht";
    public static final String COL_1_5 = "week";
    public static final String COL_1_6 = "percent";




    public DatabaseVak(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE0 + " (id INTEGER primary key,naam text, datum " +
                "text, semester INTEGER," +
                "week1 text,week2 text,week3 text,week4 text,week5 text," +
                "week6 text,week7 text,week8 text,week9 text,week10 text," +
                "week11 text,week12 text)");
        db.execSQL("create table " + DATABASE_TABLE1  + " (id INTEGER primary key,datum text,lesid INTEGER, bericht text,week INTEGER,percent INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE0);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE1);
        onCreate(db);
    }



    //TABLE0
    public int IDMAKERTABLE0() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from "+ DATABASE_TABLE0, null
        );
        return cursor.getCount();
    }

    public void insertObjectTable0(String les, int semester) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Date calender = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.FULL).format(calender);

        contentValues.put(COL_0_1, IDMAKERTABLE0());
        contentValues.put(COL_0_2, les);
        contentValues.put(COL_0_3, deDatum);
        contentValues.put(COL_0_4, semester);
        contentValues.put(COL_0_5, "null");
        contentValues.put(COL_0_6, "null");
        contentValues.put(COL_0_7, "null");
        contentValues.put(COL_0_8, "null");
        contentValues.put(COL_0_9, "null");
        contentValues.put(COL_0_10, "null");
        contentValues.put(COL_0_11, "null");
        contentValues.put(COL_0_12, "null");
        contentValues.put(COL_0_13, "null");
        contentValues.put(COL_0_14, "null");
        contentValues.put(COL_0_15, "null");
        contentValues.put(COL_0_16, "null");
        sqLiteDatabase.insert(DATABASE_TABLE0, null, contentValues);
    }

    public String getLetters(int id){
        String uit = "";
        String naam = getNaamLes(id);
        uit += naam.charAt(0);
        String laatsteLetter = "";
        laatsteLetter += ""+naam.charAt(naam.length()-1);
        if (naam.equals("null")){
            uit = "?";
        }
        if (Character.isDigit(laatsteLetter.charAt(0))){
            uit+= laatsteLetter;
        }
        return uit;

    }

    public String getNaamLes(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_0_2+" from "+DATABASE_TABLE0+" where id == " + id, null);
        if (cursor.moveToFirst()) {
            stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString();
    }

    public String getDatumLes(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_0_3+" from "+DATABASE_TABLE0+" where id == " + id, null);
        if (cursor.moveToFirst()) {
            stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString();
    }

    public int getSemesterLes(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_0_4+" from "+DATABASE_TABLE0+" where id == " + id, null);
        if (cursor.moveToFirst()) {
            stringBuffer.append(cursor.getString(0));
        }
        return Integer.parseInt(stringBuffer.toString());
    }

    public void updateFalse(int i, int id) {
        if (i < 1 || i > 12) throw new IllegalArgumentException("de piemel is kapot ik herhaal de piemel is kapot");
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0_1, id);
        contentValues.put(COL_0_2, getNaamLes(id));
        contentValues.put(COL_0_3, getDatumLes(id));
        contentValues.put(COL_0_4, getSemesterLes(id));
        if (i == 1) {
            contentValues.put(COL_0_5, "false");
        } else if (i == 2) {
            contentValues.put(COL_0_6, "false");
        } else if (i == 3) {
            contentValues.put(COL_0_7, "false");
        } else if (i == 4) {
            contentValues.put(COL_0_8, "false");
        } else if (i == 5) {
            contentValues.put(COL_0_9, "false");
        } else if (i == 6) {
            contentValues.put(COL_0_10, "false");
        } else if (i == 7) {
            contentValues.put(COL_0_11, "false");
        } else if (i == 8) {
            contentValues.put(COL_0_12, "false");
        } else if (i == 9) {
            contentValues.put(COL_0_13, "false");
        } else if (i == 10) {
            contentValues.put(COL_0_14, "false");
        } else if (i == 11) {
            contentValues.put(COL_0_15, "false");
        } else if (i == 12) {
            contentValues.put(COL_0_16, "false");
        }
        sqLiteDatabase.update(DATABASE_TABLE0, contentValues, "id = ?", new String[]{"" + id});
    }

    public void updateTrue(int i, int id) {
        if (i < 1 || i > 12) throw new IllegalArgumentException("de piemel is kapot ik herhaal de piemel is kapot");
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0_1, id);
        contentValues.put(COL_0_2, getNaamLes(id));
        contentValues.put(COL_0_3, getDatumLes(id));
        contentValues.put(COL_0_4, getSemesterLes(id));
        if (i == 1) {
            contentValues.put(COL_0_5, "True");
        } else if (i == 2) {
            contentValues.put(COL_0_6, "True");
        } else if (i == 3) {
            contentValues.put(COL_0_7, "True");
        } else if (i == 4) {
            contentValues.put(COL_0_8, "True");
        } else if (i == 5) {
            contentValues.put(COL_0_9, "True");
        } else if (i == 6) {
            contentValues.put(COL_0_10, "True");
        } else if (i == 7) {
            contentValues.put(COL_0_11, "True");
        } else if (i == 8) {
            contentValues.put(COL_0_12, "True");
        } else if (i == 9) {
            contentValues.put(COL_0_13, "True");
        } else if (i == 10) {
            contentValues.put(COL_0_14, "True");
        } else if (i == 11) {
            contentValues.put(COL_0_15, "True");
        } else if (i == 12) {
            contentValues.put(COL_0_16, "True");
        }
        sqLiteDatabase.update(DATABASE_TABLE0, contentValues, "id = ?", new String[]{"" + id});
    }
    public void updateVak(int id , String les, int semester) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0_1, id);
        contentValues.put(COL_0_2, les);
        contentValues.put(COL_0_3, getDatumLes(id));
        contentValues.put(COL_0_4, semester);
        contentValues.put(COL_0_5, "null");
        contentValues.put(COL_0_6, "null");
        contentValues.put(COL_0_7, "null");
        contentValues.put(COL_0_8, "null");
        contentValues.put(COL_0_9, "null");
        contentValues.put(COL_0_10, "null");
        contentValues.put(COL_0_11, "null");
        contentValues.put(COL_0_12, "null");
        contentValues.put(COL_0_13, "null");
        contentValues.put(COL_0_14, "null");
        contentValues.put(COL_0_15, "null");
        contentValues.put(COL_0_16, "null");
        sqLiteDatabase.update(DATABASE_TABLE0, contentValues, "id = ?", new String[]{"" + id});
    }

    public String getWeek(int id, int i){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select week"+i+" from "+DATABASE_TABLE0+" where id == " + id, null);
        if (cursor.moveToFirst()) {
            stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString().trim();
    }

    public boolean erZijnAlDatas(){
        Boolean uit = false;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from vakken",null);
        if (cursor.getCount() > 0){
            uit = true;
        }
        return uit;
    }

    public void insertZesVaken(){
        if (!erZijnAlDatas()){
            insertObjectTable0("null",1);
            insertObjectTable0("null",1);
            insertObjectTable0("null",1);
            insertObjectTable0("null",1);
            insertObjectTable0("null",1);
            insertObjectTable0("null",1);
        }
    }



    //TABLE1

    public int IDMAKERTABLE1() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from "+ DATABASE_TABLE1, null
        );
        return cursor.getCount();
    }
    public void insertObjectTable1(int lesid, String bericht,int weekid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Date calender = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.FULL).format(calender);

        contentValues.put(COL_1_1, IDMAKERTABLE1());
        contentValues.put(COL_1_2, deDatum);
        contentValues.put(COL_1_3, lesid);
        contentValues.put(COL_1_4, bericht);
        contentValues.put(COL_1_5, weekid);
        contentValues.put(COL_1_6,0);
        sqLiteDatabase.insert(DATABASE_TABLE1, null, contentValues);
    }
    public Integer geefAantalDataVanDieWeek(int id,int iweek) {
        int uit = -1;
        Cursor cursor = getWritableDatabase().rawQuery("select * from "+DATABASE_TABLE1+" where lesid == " + id + " and week == " + iweek, null);
        uit = cursor.getCount();
        return uit;
    }
    public Boolean erIsAlInfo(int id,int iweek) {
        int uit = -1;
        Cursor cursor = getWritableDatabase().rawQuery("select * from "+DATABASE_TABLE1+" where lesid == " + id + " and week == " + iweek, null);
        uit = cursor.getCount();
        if (uit > 0){
            return true;
        } else {
            return false;
        }
    }
    public String getTextOnly(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_1_4+" from "+DATABASE_TABLE1+" where id == "+ id,
                null);
        if (cursor.moveToPosition(0)) {
            stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString().trim() ;
    }
    public String bericht(int lesid,int weekid,int pos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_1_4+" from "+DATABASE_TABLE1+" where lesid == " + lesid + " and week == "+ weekid, null);
        if (cursor.moveToPosition(pos)){
            stringBuffer.append(cursor.getString(0));
        }
        return stringBuffer.toString().trim() + ":: "+ getPercent(lesid,weekid,pos) + "%";
    }
    public String getPercent(int lesid,int weekid,int pos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        if (erIsAlInfo(lesid,weekid)){
            Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_1_6+" from "+DATABASE_TABLE1+" where lesid == " + lesid + " and week == "+ weekid, null);
            if (cursor.moveToPosition(pos)){
                stringBuffer.append(cursor.getString(0));
            }
        }
        return stringBuffer.toString().trim();
    }
    public String getPercentID(int lesid,int weekid,int pos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        if (erIsAlInfo(lesid,weekid)){
            Cursor cursor =
                    sqLiteDatabase.rawQuery("select "+COL_1_1+" from "+DATABASE_TABLE1+" where lesid == " + lesid + " " +
                            "and week == "+ weekid, null);
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

    public void updateTo50(int idObject , int lesid , int weekid){
        Date calendar = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1_1, idObject);
        contentValues.put(COL_1_2, deDatum);
        contentValues.put(COL_1_3, lesid);
        contentValues.put(COL_1_4, getTextOnly(idObject));
        contentValues.put(COL_1_5, weekid);
        contentValues.put(COL_1_6, 50);
        sqLiteDatabase.update(DATABASE_TABLE1, contentValues, "id = ?", new String[]{""+idObject});
    }
    public void updateTo100(int idObject , int lesid , int weekid){
        Date calendar = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1_1, idObject);
        contentValues.put(COL_1_2, deDatum);
        contentValues.put(COL_1_3, lesid);
        contentValues.put(COL_1_4, getTextOnly(idObject));
        contentValues.put(COL_1_5, weekid);
        contentValues.put(COL_1_6, 100);
        sqLiteDatabase.update(DATABASE_TABLE1, contentValues, "id = ?", new String[]{""+idObject});
    }

    public void updateTo0(int idObject , int lesid , int weekid){
        Date calendar = Calendar.getInstance().getTime();
        String deDatum = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1_1, idObject);
        contentValues.put(COL_1_2, deDatum);
        contentValues.put(COL_1_3, lesid);
        contentValues.put(COL_1_4, getTextOnly(idObject));
        contentValues.put(COL_1_5, weekid);
        contentValues.put(COL_1_6, 0);
        sqLiteDatabase.update(DATABASE_TABLE1, contentValues, "id = ?", new String[]{""+idObject});
    }
    public String getTotalPercentage(int lesid,int weekid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        if (erIsAlInfo(lesid,weekid)){
            Cursor cursor =
                    sqLiteDatabase.rawQuery("select sum(percent) from "+DATABASE_TABLE1+" where lesid == " + lesid + " and week == "+ weekid, null);
            if (cursor.moveToFirst()){
                stringBuffer.append(cursor.getString(0));
            }
        }
        return stringBuffer.toString().trim();
    }
    public int getGrote(int lesid,int weekid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        int a = 0;
        if (erIsAlInfo(lesid,weekid)){
            Cursor cursor =
                    sqLiteDatabase.rawQuery("select * from "+DATABASE_TABLE1+" where lesid == " + lesid + " " +
                            "and week == "+ weekid, null);
            a = cursor.getCount();
        }
        if (a == 0){
            a = 1;
        }
        return a;
    }
    public void delete(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(DATABASE_TABLE1,"id = ?",new String[] {""+id});
    }
    public String id(int lesid , int pos){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_1_1+" from "+DATABASE_TABLE1+" where lesid == " + lesid,null);
        cursor.moveToPosition(pos);
        return stringBuffer.append(cursor.getString(0)).toString();
    }
    public Integer getLengthIdQuery(int lesid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+COL_1_1+" from "+DATABASE_TABLE1+" where lesid == " + lesid,null);
        return cursor.getCount();
    }
    public ArrayList<String>ids(int lesid){
        ArrayList<String>cijfer = new ArrayList<>();
        for (int i = 0; i < getLengthIdQuery(lesid);i++){
            cijfer.add(id(lesid,i));
        }
        return cijfer;
    }
}
