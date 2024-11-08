package com.example.advancedpcproject;

import static com.example.advancedpcproject.DatabaseHelper.databaseName;
import static com.example.advancedpcproject.DatabaseHelper.databaseVersion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SetColor extends SQLiteOpenHelper {



    private static final String TABLE_DATA_CREATE_3 = "CREATE TABLE " +TablesInfo.DataEntry.TABLE_NAME_3+"( " + TablesInfo.DataEntry.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + TablesInfo.DataEntry.COLUMN_COLOR+" TEXT ," + TablesInfo.DataEntry.COLUMN_CREATE_DATE+
            " TEXT DEFAULT CURRENT_TIMESTAMP" + ")";

    public SetColor(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sq2) {
        sq2.execSQL(TABLE_DATA_CREATE_3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sq2, int i, int i1) {

    }
    public void addColor(String color){

        SQLiteDatabase sq2 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TablesInfo.DataEntry.COLUMN_COLOR,color);

        sq2.insert(TablesInfo.DataEntry.TABLE_NAME_3,null, cv);

        // sq2.close();
    }
}
