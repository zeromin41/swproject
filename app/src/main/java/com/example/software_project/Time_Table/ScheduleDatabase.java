/*package com.example.software_project.Time_Table;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavi.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Subject_Manager extends AppCompatActivity {
    private ArrayList<SubjectInfo> subjectsList = new ArrayList<>();
    private Map<String, FrameLayout> frameLayoutMap; // 요일과 시간에 따른 FrameLayout 매핑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1);

        // 저장된 과목 정보를 불러옵니다.
        SharedPreferences prefs = getSharedPreferences("Subjects", MODE_PRIVATE);
        String json = prefs.getString("subjectsList", null);
        Type type = new TypeToken<ArrayList<SubjectInfo>>() {
        }.getType();
        subjectsList = new Gson().fromJson(json, type);
        if (subjectsList == null) {
            subjectsList = new ArrayList<>();
            // 초기 과목 리스트를 설정합니다. 실제 앱에서는 저장된 데이터가 없을 경우를 위한 기본 데이터일 수 있습니다.
            initializeSubjects();
        }

        // FrameLayout 매핑 초기화
        initializeFrameLayoutMap();

        // 과목 상세 정보를 UI에 적용
        applySubjectsToUI();

    }
    // 여기서 각 FrameLayout을 요일과 시간대로 매핑합니다.
    private void initializeFrameLayoutMap() {
        frameLayoutMap = new HashMap<>();
        frameLayoutMap.put("월09:00", findViewById(R.id.mon_9));
        frameLayoutMap.put("월09:30", findViewById(R.id.mon_9_5));
        // ... 나머지 FrameLayout들에 대해서도 같은 방식으로 초기화합니다.
    }

    private void applySubjectsToUI() {
        for (SubjectInfo subject : subjectsList) {
            String key = subject.getDay() + subject.getTime(); // '월09:00'과 같은 형태의 키 생성
            FrameLayout subjectFrameLayout = frameLayoutMap.get(key);
            if (subjectFrameLayout != null) {
                // ListView에 추가된 과목명과 일치할 때만 색상을 적용합니다.
                if (subjectsList.contains(subject.getName())) {
                    // 과목의 색상을 해당 FrameLayout의 배경색으로 설정합니다.
                    subjectFrameLayout.setBackgroundColor(subject.getColor());
                    // 추가적으로 과목의 이름을 표시하는 TextView를 설정할 수 있습니다.
                    TextView textView = new TextView(this);
                    textView.setText(subject.getName());
                    subjectFrameLayout.addView(textView);
                }
            }
        }
    }

    private void initializeSubjects() {
        subjectsList.add(new SubjectInfo("컴퓨터 공학 입문과 파이썬", "월", "09:00", Color.RED));
        // ... 다른 과목들도 이런 식으로 추가
    }

}*/
