package com.example.advancedpcproject;

import static com.example.advancedpcproject.DatabaseHelper.databaseName;
import static com.example.advancedpcproject.DatabaseHelper.databaseVersion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SetTemperature extends SQLiteOpenHelper  {


    private static final String TABLE_DATA_CREATE_2 = "CREATE TABLE " +TablesInfo.DataEntry.TABLE_NAME_2+"( " + TablesInfo.DataEntry.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + TablesInfo.DataEntry.COLUMN_TEMP+" TEXT ," + TablesInfo.DataEntry.COLUMN_CREATE_DATE+
            " TEXT DEFAULT CURRENT_TIMESTAMP" + ")";

    public SetTemperature( Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sq3) {

        sq3.execSQL(TABLE_DATA_CREATE_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sq3, int i, int i1) {


    }

    public void addTemp(float temperature){

        SQLiteDatabase sq3 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TablesInfo.DataEntry.COLUMN_TEMP,temperature);
        //cv.put(TablesInfo.DataEntry.COLUMN_RELAY,relay);

        //ContentValues ab = new ContentValues();
        //ab.putAll(cv);
        sq3.insert(TablesInfo.DataEntry.TABLE_NAME_2,null, cv);

       // sq3.close();
    }
}
