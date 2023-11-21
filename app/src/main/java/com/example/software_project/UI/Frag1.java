package com.example.software_project.UI;
/*package com.example.bottomnavi.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.graphics.Color;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

import com.example.bottomnavi.R;
import com.example.bottomnavi.Time_Table.Subject;
import com.example.bottomnavi.Time_Table.SubjectInfo;

import org.jetbrains.annotations.Nullable;

public class Frag1 extends Fragment {
    private static final int SOME_REQUEST_CODE = 1234;
    List<SubjectInfo> subjectList = new ArrayList<>();

    Button timetableAddButton;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag1, container, false);

        timetableAddButton = rootView.findViewById(R.id.button1);
        timetableAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Subject.class);
                startActivityForResult(intent, SOME_REQUEST_CODE);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        // SubjectInfo 클래스의 static 메서드 loadSubjects를 호출하여 과목 리스트를 가져옵니다.
        subjectList = SubjectInfo.loadSubjects(getActivity());

        // subjectsList에 저장된 과목 정보를 반복해서 확인하며 시간표에 색을 칠해줍니다.
        for (SubjectInfo subject : subjectList) {
            setCellBackgroundColorBySubject(subject);
        }
    }

    // SubjectInfo 객체를 기반으로 배경색을 설정하는 메서드
    private void setCellBackgroundColorBySubject(SubjectInfo subject) {
        // SubjectInfo 객체에서 요일과 시작 시간을 가져오는 코드
        String day = subject.getDay();
        String startTime = subject.getTime();
        int color = subject.getColor();

        // 시간대에 해당하는 프레임 레이아웃 ID를 생성합니다.
        String frameLayoutId = day.toLowerCase() + "_" + startTime.replace(":", ""); // "mon_0900", "tue_1000" 등

        // 해당 프레임 레이아웃 ID를 기반으로 프레임 레이아웃을 찾아 배경색을 변경합니다.
        int resId = getResources().getIdentifier(frameLayoutId, "id", getActivity().getPackageName());
        if (resId != 0) {
            FrameLayout subjectFrameLayout = rootView.findViewById(resId);
            subjectFrameLayout.setBackgroundColor(color); // SubjectInfo 객체에서 제공하는 색으로 설정
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SOME_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            SubjectInfo subjectInfo = (SubjectInfo) data.getSerializableExtra("subjectInfo");
            if (subjectInfo != null) {
                subjectList.add(subjectInfo);
                setCellBackgroundColorBySubject(subjectInfo);
            }
        }
    }
}*/


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.software_project.R;

public class Frag1 extends Fragment {

    private View view;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        return view;
    }
}
