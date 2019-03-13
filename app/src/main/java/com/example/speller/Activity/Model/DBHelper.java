package com.example.speller.Activity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users_db";

    SQLiteDatabase db;
    ArrayList<String> a = new ArrayList<>();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS words (word VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS words");
        onCreate(db);
    }

    public void addData (String word){
        a.clear();
        try {
            db = this.getWritableDatabase();
            db.execSQL("INSERT OR REPLACE INTO words (word) VALUES ('"+word+"')");
           // db.execSQL("DELETE FROM words");
            db.close();
        }catch (Exception e){
            Log.i("dberror",String.valueOf(e));
        }
    }
    public void showData (){
        //a.clear();
        try {
            db = this.getReadableDatabase();
          //  Cursor cursor = db.rawQuery("SELECT * FROM words",null);
            Cursor cursor1= db.rawQuery("SELECT DISTINCT word  FROM words ",null);

            int wordIndex = cursor1.getColumnIndex("word");

            cursor1.moveToFirst();
            while (cursor1!=null){
                Log.i("nameeee",cursor1.getString(wordIndex));

                a.add(cursor1.getString(wordIndex)+ "\n");
                cursor1.moveToNext();
            }

            cursor1.close();

        }catch (Exception e){
            Log.i("err",String.valueOf(e));
        }
        Log.i("ABCDED",String.valueOf(a.size()));
    }
}

