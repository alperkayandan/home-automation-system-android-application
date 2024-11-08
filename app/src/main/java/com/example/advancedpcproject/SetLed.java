package com.example.advancedpcproject;

import static com.example.advancedpcproject.DatabaseHelper.databaseName;
import static com.example.advancedpcproject.DatabaseHelper.databaseVersion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SetLed extends SQLiteOpenHelper {



    public static final String TABLE_DATA_CREATE_5 = "CREATE TABLE " +TablesInfo.DataEntry.TABLE_NAME_5+"( " + TablesInfo.DataEntry.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + TablesInfo.DataEntry.COLUMN_LED+" TEXT ," +TablesInfo.DataEntry.COLUMN_CREATE_DATE+
            " TEXT DEFAULT CURRENT_TIMESTAMP" + ")";

    public SetLed(Context context) {

        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL(TABLE_DATA_CREATE_5);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sq, int i, int i1) {

    }
    public void addLed(int led){
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TablesInfo.DataEntry.COLUMN_LED,led);

        sq.insert(TablesInfo.DataEntry.TABLE_NAME_5,null, cv);

        //sq.close();
    }
}
