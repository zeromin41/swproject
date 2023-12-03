package com.example.software_project.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.software_project.R;

public class Frag5 extends Fragment {

    private CheckBox graduationProjectCheckbox;
    private CheckBox educationTrainingCheckbox;
    private CheckBox internship;
    private CheckBox thesis;
    private CheckBox toeic;
    private CheckBox license;

    private TextView scoreTextView;

    private double totalScore = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag5, container, false);

        // XML에서 정의한 각 뷰의 ID 가져오기
        graduationProjectCheckbox = view.findViewById(R.id.graduationProjectCheckbox);
        educationTrainingCheckbox = view.findViewById(R.id.educationTrainingCheckbox);
        internship = view.findViewById(R.id.internship);
        license = view.findViewById(R.id.license);
        toeic = view.findViewById(R.id.toeic);
        thesis = view.findViewById(R.id.thesis);

        scoreTextView = view.findViewById(R.id.scoreTextView);

        // 체크박스의 상태 변화 감지
        graduationProjectCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // 졸업 작품 체크 시 3.0점 추가
                totalScore += 3.0;
            } else {
                // 체크 해제 시 3.0점 감소
                totalScore -= 3.0;
            }
            updateScore();
        });

        educationTrainingCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // 교육 훈련 체크 시 2.0점 추가
                totalScore += 2.0;
            } else {
                // 체크 해제 시 2.0점 감소
                totalScore -= 2.0;
            }
            updateScore();
        });

        license.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                totalScore += 1.5;
            } else {
                totalScore -= 1.5;
            }
            updateScore();
        });

        toeic.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                totalScore += 1.5;
            } else {
                totalScore -= 1.5;
            }
            updateScore();
        });

        thesis.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                totalScore += 1.5;
            } else {
                totalScore -= 1.5;
            }
            updateScore();
        });

        internship.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                totalScore += 1.5;
            } else {
                totalScore -= 1.5;
            }
            updateScore();
        });

        return view;
    }

    private void updateScore() {
        // 합산점수을 표시하는 TextView 업데이트
        scoreTextView.setText(String.format("합산점수 : %.1f", totalScore));
    }
}