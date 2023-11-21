/*package com.example.software_project.Time_Table;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Subject_Info {

    private String name;
    private String day;
    private String time;
    private int color;

    private static final String SHARED_PREFERENCES_NAME = "SubjectData";
    private static final String SUBJECT_LIST_KEY = "subjectList";
    private static final Gson gson = new Gson();
    private static final Type SUBJECT_LIST_TYPE = new TypeToken<List<SubjectInfo>>() {}.getType();

    // 생성자
    public SubjectInfo(String Name, String day, String time, int color) {
        this.name = Name;
        this.day = day;
        this.time = time;
        this.color = color;
    }

    // name에 대한 getter와 setter
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    // day에 대한 getter와 setter
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    // time에 대한 getter와 setter
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // color에 대한 getter와 setter
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    // SharedPreferences를 사용하여 과목 정보를 저장하는 메서드
    public static void saveSubjectsList(Context context, List<SubjectInfo> subjectList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String json = gson.toJson(subjectList);
        editor.putString(SUBJECT_LIST_KEY, json);
        editor.apply();
    }

    // SharedPreferences에서 과목 정보를 불러오는 메서드
    public static List<SubjectInfo> loadSubjects(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(SUBJECT_LIST_KEY, "");

        List<SubjectInfo> subjectList = gson.fromJson(json, SUBJECT_LIST_TYPE);
        if (subjectList == null) {
            subjectList = new ArrayList<>();
        }

        return subjectList;
    }
}*/
