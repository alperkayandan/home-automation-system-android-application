package com.example.advancedpcproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName ="Otomasyon.db";
    public static final int databaseVersion= 1;

    private static final String TABLE_DATA_CREATE = "CREATE TABLE " + TablesInfo.DataEntry.TABLE_NAME +"( " +TablesInfo.DataEntry.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + TablesInfo.DataEntry.COLUMN_RELAY +" TEXT ,"+TablesInfo.DataEntry.COLUMN_CREATE_DATE+
            " TEXT DEFAULT CURRENT_TIMESTAMP" + ")";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_DATA_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int databaseVersion, int databaseVersion2) {


    }

    public void addRelay(int relay){

         SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
         ContentValues cv = new ContentValues();

         cv.put(TablesInfo.DataEntry.COLUMN_RELAY,relay);

         sqLiteDatabase.insert(TablesInfo.DataEntry.TABLE_NAME,null, cv);

        // sqLiteDatabase.close();
    }


}


