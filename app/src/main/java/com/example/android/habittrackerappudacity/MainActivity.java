package com.example.android.habittrackerappudacity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.android.habittrackerappudacity.data.HabitsDbHelper;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSERT DUMMY DATA
        HabitsDbHelper mDbHelper = new HabitsDbHelper(this);
        //DUMMY DATA 1
        mDbHelper.insterData(
                "Swimming",
                1,
                "07-07-2017",
                60,
                "Practicing on back style.",
                3);
        //DUMMY DATA 2
        mDbHelper.insterData(
                "Gambling",
                2,
                "08-07-2017",
                10,
                "Lost too much...",
                3);
        //DUMMY DATA 3
        mDbHelper.insterData(
                "Playing video games",
                0,
                "09-07-2017",
                90,
                "Eyes: hurt, mood: better.",
                1);

        //READING ALL THE DATA
        Cursor readCursor = mDbHelper.queryAllData();
        //GOING THROUGH THE CURSORS CONTENT ROW BY ROW AND LOG IT BECAUSE THERE IS NO UI
        try {
            while (readCursor.moveToNext()) {
                Log.e(LOG_TAG,
                        "Habit: " + readCursor.getInt(0) + " | "
                                   + readCursor.getString(1) + " | "
                                   + readCursor.getInt(2) + " | "
                                   + readCursor.getString(3) + " | "
                                   + readCursor.getInt(4) + " | "
                                   + readCursor.getString(5) + " | "
                                   + readCursor.getInt(6) + "\n");
            }
        } finally {
            //CLOSING THE CURSOR TO PREVENT MEMORY LEAKS
            readCursor.close();
        }
    }
}
