package com.example.software_project.Time_Table;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Schedule_Info.class}, version = 1, exportSchema = false)
public abstract class ScheduleDatabase extends RoomDatabase {
    public abstract ScheduleDao ScheduleDao();
}
