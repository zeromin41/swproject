package com.example.software_project.Time_Table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimetableDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "timetable.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TIMETABLE =
            "CREATE TABLE " + TimetableContract.TimetableEntry.TABLE_NAME + " (" +
                    TimetableContract.TimetableEntry._ID + " INTEGER PRIMARY KEY," +
                    TimetableContract.TimetableEntry.COLUMN_DAY + " TEXT," +
                    TimetableContract.TimetableEntry.COLUMN_TIME + " TEXT," +
                    TimetableContract.TimetableEntry.COLUMN_SUBJECT + " TEXT)";

    private static final String SQL_DELETE_TIMETABLE =
            "DROP TABLE IF EXISTS " + TimetableContract.TimetableEntry.TABLE_NAME;

    public TimetableDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TIMETABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TIMETABLE);
        onCreate(db);
    }

    // 데이터베이스에 데이터 추가
    public void insertTimetable(String day, String time, String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TimetableContract.TimetableEntry.COLUMN_DAY, day);
        values.put(TimetableContract.TimetableEntry.COLUMN_TIME, time);
        values.put(TimetableContract.TimetableEntry.COLUMN_SUBJECT, subject);
        db.insert(TimetableContract.TimetableEntry.TABLE_NAME, null, values);
        db.close();
    }

    // 데이터베이스에서 모든 시간표 데이터를 가져오는 메서드
    public Cursor getAllTimetables() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                TimetableContract.TimetableEntry._ID,
                TimetableContract.TimetableEntry.COLUMN_DAY,
                TimetableContract.TimetableEntry.COLUMN_TIME,
                TimetableContract.TimetableEntry.COLUMN_SUBJECT
        };

        // 쿼리를 실행하여 결과를 반환
        return db.query(
                TimetableContract.TimetableEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
}

