package com.example.advancedpcproject;

import android.provider.BaseColumns;

public class TablesInfo {

    public static final class DataEntry implements BaseColumns {

        public static final String TABLE_NAME = "role_durum";
        public static final String TABLE_NAME_2="sicaklik";
        public static final String TABLE_NAME_3="led_renk";
        public static final String TABLE_NAME_4="hiz";
        public static final String TABLE_NAME_5="led_durum";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_CREATE_DATE = "date";
        public static final String COLUMN_TEMP = "temperature";
        public static final String COLUMN_RELAY = "State_of_Relay";
        public static final String COLUMN_SPEED = "Speed";
        public static final String COLUMN_COLOR = "Color_of_Led";
        public static final String COLUMN_LED = "State_of_Led";

    }

}
