package com.example.software_project.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.software_project.R;

public class Frag4 extends Fragment {

    private MyViewModel viewModel;

    private CheckBox graduationProjectCheckbox;
    private CheckBox educationTrainingCheckbox;
    private CheckBox internship;
    private CheckBox license;
    private CheckBox toeic;
    private CheckBox thesis;

    private TextView scoreTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag4, container, false);

        // ViewModel 초기화
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // XML에서 정의한 각 뷰의 ID 가져오기
        graduationProjectCheckbox = view.findViewById(R.id.graduationProjectCheckbox);
        educationTrainingCheckbox = view.findViewById(R.id.educationTrainingCheckbox);
        internship = view.findViewById(R.id.internship);
        license = view.findViewById(R.id.license);
        toeic = view.findViewById(R.id.toeic);
        thesis = view.findViewById(R.id.thesis);

        scoreTextView = view.findViewById(R.id.scoreTextView);

        // 체크박스의 상태 설정
        graduationProjectCheckbox.setChecked(viewModel.isGraduationProjectChecked());
        educationTrainingCheckbox.setChecked(viewModel.isEducationTrainingChecked());
        internship.setChecked(viewModel.isInternshipChecked());
        license.setChecked(viewModel.isLicenseChecked());
        toeic.setChecked(viewModel.isToeicChecked());
        thesis.setChecked(viewModel.isThesisChecked());

        // 체크박스의 상태 변화 감지
        graduationProjectCheckbox.setOnCheckedChangeListener(this::onCheckboxChanged);
        educationTrainingCheckbox.setOnCheckedChangeListener(this::onCheckboxChanged);
        internship.setOnCheckedChangeListener(this::onCheckboxChanged);
        license.setOnCheckedChangeListener(this::onCheckboxChanged);
        toeic.setOnCheckedChangeListener(this::onCheckboxChanged);
        thesis.setOnCheckedChangeListener(this::onCheckboxChanged);

        // 초기 합산점수 설정
        updateScore();

        return view;
    }

    private void onCheckboxChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.graduationProjectCheckbox:
                viewModel.setGraduationProjectChecked(isChecked);
                viewModel.addToTotalScore(isChecked ? 3.0 : -3.0);
                break;
            case R.id.educationTrainingCheckbox:
                viewModel.setEducationTrainingChecked(isChecked);
                viewModel.addToTotalScore(isChecked ? 2.0 : -2.0);
                break;
            case R.id.internship:
                viewModel.setInternshipChecked(isChecked);
                viewModel.addToTotalScore(isChecked ? 1.5 : -1.5);
                break;
            case R.id.license:
                viewModel.setLicenseChecked(isChecked);
                viewModel.addToTotalScore(isChecked ? 1.5 : -1.5);
                break;
            case R.id.toeic:
                viewModel.setToeicChecked(isChecked);
                viewModel.addToTotalScore(isChecked ? 1.5 : -1.5);
                break;
            case R.id.thesis:
                viewModel.setThesisChecked(isChecked);
                viewModel.addToTotalScore(isChecked ? 1.5 : -1.5);
                break;
        }

        updateScore();
    }

    private void updateScore() {
        // 합산점수를 표시하는 TextView 업데이트
        scoreTextView.setText(String.format("합산점수 : %.1f", viewModel.getTotalScore()));
    }
}
