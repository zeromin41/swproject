package com.example.software_project.Time_Table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SCHEDULE")
public class Schedule_Info {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public long id;
    @ColumnInfo(name = "day")
    public String day;
    @ColumnInfo(name = "time")
    public String time;
    @ColumnInfo(name = "subject")
    public String subject;
    @ColumnInfo(name = "state")
    public boolean state;

    public Schedule_Info( String day, String time, String subject,boolean state) {

        this.day = day;
        this.time = time;
        this.subject = subject;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }
    public boolean getState() {
        return state;
    }
}
