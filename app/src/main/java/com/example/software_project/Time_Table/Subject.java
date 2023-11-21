/*package com.example.software_project.Time_Table;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavi.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Subject extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;  // 클래스 변수로 선언되어 있으므로 onCreate에서 다시 선언할 필요가 없습니다.
    ListView listView;  // 마찬가지로 클래스 변수입니다.
    ImageButton saveButton;
    private ArrayList<SubjectInfo> subjectsList;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeadd);

        // SharedPreferences에서 과목 목록을 불러와 초기화
        SharedPreferences prefs = getSharedPreferences("Subjects", MODE_PRIVATE);
        String json = prefs.getString("subjectsList", "");
        if (!TextUtils.isEmpty(json)) {
            Type type = new TypeToken<ArrayList<SubjectInfo>>() {}.getType();
            subjectsList = new Gson().fromJson(json, type);
        } else {
            subjectsList = new ArrayList<>();
        }

        String[] subjects = {"컴퓨터 공학 입문과 파이썬", "프로그래밍 입문", "객체지향 프로그래밍 1", "리눅스 시스템 프로그래밍", "웹 프로그래밍",
                "자료구조", "파이썬 데이터 분석", "객체지향 프로그래밍 2", "게임 프로그래밍", "알고리즘", "이산수학", "컴퓨터 구조", "시스템 분석 및 설계",
                "프로그래밍 언어", "머신러닝", "모바일프로그래밍", "컴퓨터네트워크", "운영체제", "소프트웨어공학", "데이터 베이스", "딥 러닝",
                "융합 소프트웨어 프로젝트", "컴퓨터 그래픽스", "IoT 프로그래밍", "디지털 영상 처리", "융합 소프트웨어 종합 설계_1", "멀티 미디어 공학",
                "융합소프트웨어종합설계2"};

        autoCompleteTextView = findViewById(R.id.autocomplete_subject);
        listView = findViewById(R.id.subject_list);
        ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, subjects);
        autoCompleteTextView.setAdapter(autoAdapter);

        ArrayList<String> subjectList = new ArrayList<>();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item_custom, subjectList);
        listView.setAdapter(listAdapter);

        autoCompleteTextView.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                String enteredText = v.getText().toString();

                if (!subjectList.contains(enteredText)) {  // 중복 검사
                    subjectList.add(enteredText);

                    SubjectInfo newSubject = new SubjectInfo(enteredText, "월", "09:00", Color.RED);
                    subjectsList.add(newSubject);

                    listAdapter.notifyDataSetChanged();
                    v.setText("");
                } else {
                    Toast.makeText(Subject.this, "과목이 이미 추가되었습니다.", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
            return false;
        });

        // 저장 버튼 클릭 이벤트 처리
        saveButton = findViewById(R.id.imageButton2);
        saveButton.setOnClickListener(v -> {
            // 과목 정보를 SharedPreferences에 저장합니다.
            /*SharedPreferences.Editor editor = prefs.edit();
            editor.putString("subjectsList", new Gson().toJson(subjectsList));
            editor.apply();*/
// 과목 정보를 SharedPreferences에 저장합니다. 아래 코드 대신 saveSubjectsList 메서드 호출
            /*SubjectInfo.saveSubjectsList(getApplicationContext(), subjectsList);

            // 결과를 설정하고 액티비티를 종료합니다.
            Intent resultIntent = new Intent();
            resultIntent.putExtra("subject_added", true);
            setResult(RESULT_OK, resultIntent);
            finish();

        });
    }

}*/