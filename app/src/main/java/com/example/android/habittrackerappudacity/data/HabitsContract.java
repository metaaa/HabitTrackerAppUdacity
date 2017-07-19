package com.example.android.habittrackerappudacity.data;

import android.provider.BaseColumns;

//PREPARING THE DATABASE'S SCHEME
public class HabitsContract {
    //EMPTY CONSTRUCTOR
    private HabitsContract() {}
    //DEFINING THE CONSTANT VALUES FOR THE TABLE
    public class HabitsEntry implements BaseColumns {
        //NAME OF THE DATABASE TABLE
        public static final String TABLE_NAME = "habits";
        //UNIQUE ID FOR THE RECORDS - INTEGER
        public static final String _ID = BaseColumns._ID;
        //NAME OF THE HABIT - TEXT
        public static final String HABIT_NAME = "habit_name";
        //TYPE OF THE HABIT - INTEGER
        public static final String HABIT_TYPE = "habit_type";
        //DATE OF THE HABIT - TEXT
        public static final String HABIT_DATE = "habit_date";
        //DURATION OF THE HABIT IN MINUTES - INTEGER
        public static final String HABIT_DURATION_IN_MINUTES = "habit_duration_in_minutes";
        //SHORT DESCRIPTION OF THE HABIT - TEXT
        public static final String HABIT_DESCRIPTION = "habit_description";
        //PLACE WHERE THE HABIT OCCURED - TEXT
        public static final String HABIT_PLACE = "habit_place";

        //VALUES FOR THE HABIT_TYPE
        public static final int HABIT_TYPE_GOOD = 1;
        public static final int HABIT_TYPE_BAD = 2;
        public static final int HABIT_TYPE_UNDECIDED = 0;

        //VALUES FOR THE HABIT_PLACE
        public static final int HABIT_PLACE_HOME = 1;
        public static final int HABIT_PLACE_WORK = 2;
        public static final int HABIT_PLACE_OUTSIDE = 3;
        public static final int HABIT_PLACE_DURING_TRAVEL = 4;
        public static final int HABIT_PLACE_ELSE = 0;

    }
}
