package com.example.software_project.Time_Table;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScheduleDao {
    @Query("SELECT * FROM SCHEDULE")
    List<Schedule_Info> getAll();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserInfo(Schedule_Info user_info);
}