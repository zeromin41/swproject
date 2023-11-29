package com.example.software_project.Time_Table;

import android.provider.BaseColumns;

public class TimetableContract {
    private TimetableContract() {}

    public static class TimetableEntry implements BaseColumns {
        public static final String TABLE_NAME = "timetable";
        public static final String COLUMN_DAY = "day";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_SUBJECT = "subject";
    }
}

