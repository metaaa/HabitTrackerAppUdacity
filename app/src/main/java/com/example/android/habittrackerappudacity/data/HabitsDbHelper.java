package com.example.android.habittrackerappudacity.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitsDbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "habits.db";

    private static final int DB_VERSION = 1;

    public HabitsDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //THIS STRING HOLDS THE COMMAND TO CREATE THE SQL TABLE
        String SQL_CREATE_TABLE ="CREATE TABLE " + HabitsContract.HabitsEntry.TABLE_NAME + "("
                + HabitsContract.HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsContract.HabitsEntry.HABIT_NAME + " TEXT NOT NULL, "
                + HabitsContract.HabitsEntry.HABIT_TYPE + " INTEGER NOT NULL DEFAULT 0, "
                + HabitsContract.HabitsEntry.HABIT_DATE + " TEXT NOT NULL, "
                + HabitsContract.HabitsEntry.HABIT_DURATION_IN_MINUTES + " INTEGER NOT NULL, "
                + HabitsContract.HabitsEntry.HABIT_DESCRIPTION + " TEXT, "
                + HabitsContract.HabitsEntry.HABIT_PLACE + " INTEGER NOT NULL);";
        //EXECUTING THE SQL COMMAND TO CREATE THE TABLE
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //THIS MAKES NOTHING YET
    }

    //THIS METHOD WILL INSERT NEW DATA TO THE DATABASE
    public void insterData(String name, int type, String date, int durationInMinutes, String description, int place){

        //PREPARING TABLE TO WRITE DATA INTO IT
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        //PUTTING DATA INTO THE CONTENTVALUES
        ContentValues habitContentValues = new ContentValues();
        habitContentValues.put(HabitsContract.HabitsEntry.HABIT_NAME, name);
        habitContentValues.put(HabitsContract.HabitsEntry.HABIT_TYPE, type);
        habitContentValues.put(HabitsContract.HabitsEntry.HABIT_DATE, date);
        habitContentValues.put(HabitsContract.HabitsEntry.HABIT_DURATION_IN_MINUTES, durationInMinutes);
        habitContentValues.put(HabitsContract.HabitsEntry.HABIT_DESCRIPTION, description);
        habitContentValues.put(HabitsContract.HabitsEntry.HABIT_PLACE, place);

        //INSERTING THE VALUES STORED IN THE CONTENT VALUES TO THE DATABASE
        sqLiteDatabase.insert(HabitsContract.HabitsEntry.TABLE_NAME, null, habitContentValues);
    }

    //THIS METHOD QUERIES THE WHOLE DATABASE WITH A CURSOR
    public Cursor queryAllData(){
        //PREPARING THE DATABASE TO READ DATA
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        //projection DEFINES THE COLUMN AFFECTED BY THE QUERY
        String[] projection = {
                HabitsContract.HabitsEntry._ID,
                HabitsContract.HabitsEntry.HABIT_NAME,
                HabitsContract.HabitsEntry.HABIT_TYPE,
                HabitsContract.HabitsEntry.HABIT_DATE,
                HabitsContract.HabitsEntry.HABIT_DURATION_IN_MINUTES,
                HabitsContract.HabitsEntry.HABIT_DESCRIPTION,
                HabitsContract.HabitsEntry.HABIT_PLACE
        };

        //RETURNING THE QUERY
        return sqLiteDatabase.query(
                HabitsContract.HabitsEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
}
