package com.example.software_project.UI;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.software_project.R;

import java.util.HashMap;
import java.util.Map;

public class Frag2 extends Fragment {

    private Spinner gradeSpinner;   //  spinner 선언
    private Spinner semesterSpinner;
    private ImageButton imageButton;
    private TextView resultTextView;

    private LinearLayout checkBoxLayout;

    private LinearLayout linearLayout;

    private int score = 0;
    private int savedScore = 0;
    private SharedPreferences sharedPreferences; // SharedPreferences 변수 추가

    private Map<String, Boolean> checkBoxStates = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gradeSpinner = getView().findViewById(R.id.gradeSpinner);
        semesterSpinner = getView().findViewById(R.id.semesterSpinner);
        imageButton = getView().findViewById(R.id.imageButton);
        checkBoxLayout = getView().findViewById(R.id.checkBoxLayout);
        linearLayout = getView().findViewById(R.id.linearLayout);


        // SharedPreferences 초기화
        sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        // 이미 저장된 체크박스 상태를 복원
        restoreCheckBoxStates();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGrade = gradeSpinner.getSelectedItem().toString();
                String selectedSemester = semesterSpinner.getSelectedItem().toString();

                // CheckBox 항목을 불러와서 표시
                loadCheckBoxOptions(selectedGrade, selectedSemester);
                // 이미 저장된 체크박스 상태를 복원
                restoreCheckBoxStates();
            }
        });

    }

    private void loadCheckBoxOptions (String selectedGrade, String selectedSemester){
        // 선택한 학년과 학기에 따른 CheckBox 항목을 불러와서 표시
        checkBoxLayout.removeAllViews(); // 기존 CheckBox 제거

        if (selectedGrade.equals("1학년") && selectedSemester.equals("1학기")) {
            createCheckBox("컴퓨터 공학 입문과 파이썬");
        } else if (selectedGrade.equals("1학년") && selectedSemester.equals("2학기")) {
            createCheckBox("프로그래밍 입문");
        } else if (selectedGrade.equals("2학년") && selectedSemester.equals("1학기")) {
            createCheckBox("객체지향 프로그래밍_1");
            createCheckBox("리눅스 시스템 프로그래밍");
            createCheckBox("웹 프로그래밍");
            createCheckBox("자료구조");
            createCheckBox("파이썬 데이터 분석");
        } else if (selectedGrade.equals("2학년") && selectedSemester.equals("2학기")) {
            createCheckBox("객체지향 프로그래밍_2");
            createCheckBox("게임 프로그래밍");
            createCheckBox("알고리즘");
            createCheckBox("이산수학");
            createCheckBox("컴퓨터 구조");
        } else if (selectedGrade.equals("3학년") && selectedSemester.equals("1학기")) {
            createCheckBox("시스템 분석 및 설계");
            createCheckBox("프로그래밍 언어");
        } else if (selectedGrade.equals("3학년") && selectedSemester.equals("2학기")) {
            createCheckBox("데이터 베이스");
            createCheckBox("딥 러닝");
            createCheckBox("융합 소프트웨어 프로젝트");
            createCheckBox("컴퓨터 그래픽스");
        } else if (selectedGrade.equals("4학년") && selectedSemester.equals("1학기")) {
            createCheckBox("IoT 프로그래밍");
            createCheckBox("디지털 영상 처리");
            createCheckBox("융합 소프트웨어 종합 설계_1");
        } else if (selectedGrade.equals("4학년") && selectedSemester.equals("2학기")) {
            createCheckBox("멀티 미디어 공학");
        }
    }

    private void createCheckBox (String option){
        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setText(option);
        checkBoxLayout.addView(checkBox);
        checkBox.setTag(option); // 체크박스에 고유한 태그를 설정

        final String checkBoxTag = (String) checkBox.getTag(); // 체크박스의 태그를 저장

        if (checkBoxStates.containsKey(checkBoxTag)) {
            checkBox.setChecked(Boolean.TRUE.equals(checkBoxStates.get(checkBoxTag)));
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 체크박스 상태 저장
                checkBoxStates.put(checkBoxTag, isChecked);
                if (isChecked) {  //CheckBox 체크 하면 True
                    score += 3;
                } else if (!isChecked) {  //CheckBox 체크 안하면 Fasle
                    score -= 3;
                }
                // 점수 업데이트
                updateScore();
                // 체크박스 상태 저장
                //saveCheckBoxState(((String) checkBox.getTag()), isChecked);
            }
        });
    }

    private void restoreCheckBoxStates () {
        for (int i = 0; i < checkBoxLayout.getChildCount(); i++) {
            View view = checkBoxLayout.getChildAt(i);
            if (view instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) view;
                String option = (String) checkBox.getTag(); // 고유한 태그 값을 가져옴
                //String key = "checkbox_" + i; // 각 체크박스마다 고유한 키 생성
                //boolean isChecked = sharedPreferences.getBoolean(option, false); // 기본값은 false
                //checkBox.setChecked(isChecked);
                if (checkBoxStates.containsKey(option)) {
                    checkBox.setChecked(checkBoxStates.get(option));
                }
            }
        }
    }

    private void updateScore () {
        // 점수를 표시
        TextView scoreTextView = getView().findViewById(R.id.scoreTextView);
        scoreTextView.setText("총 학점 60/ " + score);
    }

    private void showToast (String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    // SharedPreferences에 체크박스 상태 저장
    private void saveCheckBoxState (String option,boolean isChecked){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(option, isChecked);
        editor.apply();
    }
}


