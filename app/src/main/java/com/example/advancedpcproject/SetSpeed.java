package com.example.advancedpcproject;



import static com.example.advancedpcproject.DatabaseHelper.databaseName;
import static com.example.advancedpcproject.DatabaseHelper.databaseVersion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SetSpeed extends SQLiteOpenHelper {



    private static final String TABLE_DATA_CREATE_4 = "CREATE TABLE " +TablesInfo.DataEntry.TABLE_NAME_4+"( " + TablesInfo.DataEntry.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + TablesInfo.DataEntry.COLUMN_SPEED+" TEXT ," + TablesInfo.DataEntry.COLUMN_CREATE_DATE+
            " TEXT DEFAULT CURRENT_TIMESTAMP" + ")";
    public SetSpeed(Context context) {

        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sq1) {
        sq1.execSQL(TABLE_DATA_CREATE_4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sq1, int i, int i1) {


    }
    public void addSpeed(int hiz){
        SQLiteDatabase sq1 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TablesInfo.DataEntry.COLUMN_SPEED,hiz);

        sq1.insert(TablesInfo.DataEntry.TABLE_NAME_4,null, cv);

       // sq1.close();
    }
}
