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

public class Frag3 extends Fragment {

    private Spinner areaSpinner;   //  spinner 선언
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
        View view = inflater.inflate(R.layout.frag3, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        areaSpinner = getView().findViewById(R.id.areaSpinner);
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
                String selectedArea = areaSpinner.getSelectedItem().toString();

                // CheckBox 항목을 불러와서 표시
                loadCheckBoxOptions(selectedArea);
                // 이미 저장된 체크박스 상태를 복원
                restoreCheckBoxStates();
            }
        });

    }
    private void loadCheckBoxOptions (String selectedArea){
        // 선택한 영역에 따른 CheckBox 항목을 불러와서 표시
        checkBoxLayout.removeAllViews(); // 기존 CheckBox 제거

        if (selectedArea.equals("1영역")) {
            createCheckBox("문학의 이해", 3);
            createCheckBox("세계의 고전과 상상력", 3);
            createCheckBox("한국인의 삶과 문학", 3);
            createCheckBox("문학과 영상", 3);
            createCheckBox("음악의 이해", 3);
            createCheckBox("세계의 민속음악", 3);
            createCheckBox("동서양미술사", 3);
            createCheckBox("미술의 감상과 비평", 3);
            createCheckBox("우리시대 영화보기", 3);
            createCheckBox("현대생활과 디자인", 3);
            createCheckBox("공연예술의 감상과 비평", 3);
            createCheckBox("SF문학과 과학적 상상력", 3);
            createCheckBox("동서양신화와 문화콘텐츠", 3);
            createCheckBox("동서양고전과 세상읽기", 3);

        } else if (selectedArea.equals("2영역")) {
            createCheckBox("부모교육론", 3);
            createCheckBox("생활 법률", 3);
            createCheckBox("생활 속의 상담심리", 3);
            createCheckBox("인간관계론", 3);
            createCheckBox("인권과 복지 사회", 3);
            createCheckBox("자기이해와생애설계", 3);
            createCheckBox("정신건강프로젝트", 3);
            createCheckBox("젠더와 심리", 3);
            createCheckBox("창의와 소통", 3);
            createCheckBox("청년심리탐구", 3);
            createCheckBox("행복의심리", 3);
            createCheckBox("청년의 삶과 사회환경", 3);
            createCheckBox("재테크와 실용금융", 3);
            createCheckBox("포용과 통합사회의 이해", 2);  //- 2학점

        } else if (selectedArea.equals("3영역")) {
            createCheckBox("공학윤리", 3);
            createCheckBox("교육학의 이해", 3);
            createCheckBox("다문화사회와 사회정책", 3);
            createCheckBox("대중문화의 이해", 3);
            createCheckBox("동양사상으로의 초대", 3);
            createCheckBox("미디어로 보는 세계종교", 3);
            createCheckBox("심리학의 이해", 3);
            createCheckBox("영화 속 철학", 3);
            createCheckBox("현대사회와 교육", 3);
            createCheckBox("현대인과 윤리", 3);
            createCheckBox("삶과 철학", 3);
            createCheckBox("현대인의성·사랑·에로티즘", 3);

        } else if (selectedArea.equals("4영역")) {
            createCheckBox("결혼과 가족", 3);
            createCheckBox("다문화교육의 이해", 3);
            createCheckBox("동서문화교류사", 3);
            createCheckBox("동양역사와 문화", 3);
            createCheckBox("법과 문화", 3);
            createCheckBox("서양역사와 문화", 3);
            createCheckBox("일본역사와 문화", 3);
            createCheckBox("통일과 한반도미래", 3);
            createCheckBox("한국근현대사", 3);
            createCheckBox("한국문화와 교육", 3);
            createCheckBox("한국역사와 문화", 3);
            createCheckBox("현대중국의 이해", 3);

        } else if (selectedArea.equals("5영역")) {
            createCheckBox("1인 미디어와 스토리텔링", 3);
            createCheckBox("기초일본어", 3);
            createCheckBox("기초중국어", 3);
            createCheckBox("논리와 비판적 사고", 3);
            createCheckBox("디지털 플랫폼과 리터러시", 3);
            createCheckBox("스페인어", 3);
            createCheckBox("시청각영어", 3);
            createCheckBox("영문강독", 3);
            createCheckBox("영어글쓰기", 3);
            createCheckBox("영어말하기2", 3);
            createCheckBox("이미지와 기호", 3);
            createCheckBox("중급일본어", 3);
            createCheckBox("중급중국어", 3);
            createCheckBox("창의성 계발", 3);
            createCheckBox("프랑스어", 3);
            createCheckBox("생활한자와 한문", 3);
            createCheckBox("수어", 2);   //- 2학점


        } else if (selectedArea.equals("6영역")) {
            createCheckBox("ESG의이해와실천", 3);
            createCheckBox("경영학콘서트", 3);
            createCheckBox("글로벌시대의 국제관계", 3);
            createCheckBox("기술경영", 3);
            createCheckBox("마케팅 이해하기", 3);
            createCheckBox("모바일혁명이야기", 3);
            createCheckBox("알기쉬운 경제이야기", 3);
            createCheckBox("인공지능과 미래사회", 3);
            createCheckBox("제4차 산업혁명 핵심기술의 이해", 3);
            createCheckBox("지적재산권의 이해", 3);
            createCheckBox("프로그래밍언어의 이해", 3);
            createCheckBox("한국경제의 이해", 3);
            createCheckBox("빅데이터와 미래산업", 3);

        } else if (selectedArea.equals("7영역")) {
            createCheckBox("과학기술과 문명", 3);
            createCheckBox("뇌와 인공지능", 3);
            createCheckBox("대학수학", 3);
            createCheckBox("미적분학1", 3);
            createCheckBox("미적분학2", 3);
            createCheckBox("생명과학", 3);
            createCheckBox("생명의기원과진화", 3);
            createCheckBox("생활 속의 수학", 3);
            createCheckBox("생활 속의 화학", 3);
            createCheckBox("선형대수학", 3);
            createCheckBox("시공간과 우주", 3);
            createCheckBox("인간.우주.문명", 3);
            createCheckBox("일반물리실험1", 1);  //- 1학점
            createCheckBox("일반물리실험2", 1);  //- 1학점
            createCheckBox("일반물리학", 3);
            createCheckBox("일반물리학1", 3);
            createCheckBox("일반물리학2", 3);
            createCheckBox("일반물리학 및 실험1", 3);
            createCheckBox("일반화학", 3);
            createCheckBox("일반화학1", 3);
            createCheckBox("일반화학2", 3);
            createCheckBox("일반화학 및 실험1", 3);
            createCheckBox("일반화학 및 실험2", 3);
            createCheckBox("일반화학실험1", 1);  //- 1학점
            createCheckBox("일반화학실험2", 1);  //- 1학점
            createCheckBox("자연과학의 이해", 3);
            createCheckBox("확률과통계", 3);

        } else if (selectedArea.equals("8영역")) {
            createCheckBox("몸과 생명", 3);
            createCheckBox("식품과 건강", 3);
            createCheckBox("생활원예", 3);
            createCheckBox("웰니스와 삶의질", 3);
            createCheckBox("웰니스와 음식정보", 3);
            createCheckBox("인간과 환경", 3);
            createCheckBox("인간과 식량", 3);
            createCheckBox("에슬레틱과 퍼스널트레이닝", 2);  //- 2학점
            createCheckBox("필라테스와 에스테틱", 2);  //- 2학점
            createCheckBox("현대사회와 스포츠", 3);
            createCheckBox("환경윤리", 3);

        } else if (selectedArea.equals("한경교양")) {
            createCheckBox("-------- 글로컬 디자인 --------", 0);
            createCheckBox("안성맞춤융합교실", 3);
            createCheckBox("안성지역학의이해", 2);  //- 2학점
            createCheckBox("내혜홀해외탐방", 2);    //- 2학점
            createCheckBox("-------- 소양교양 --------", 0);
            createCheckBox("골프", 1);            //- 1학점
            createCheckBox("국제협력론", 3);
            createCheckBox("농구", 1);            //- 1학점
            createCheckBox("리더십의이해", 3);
            createCheckBox("면접과프레젠테이션", 2); //- 2학점
            createCheckBox("배드민턴", 1);         //- 1학점
            createCheckBox("봉사활동", 1);         //- 1학점
            createCheckBox("사진으로마음읽기", 2);   //- 2학점
            createCheckBox("수상레저", 1);         //- 1학점
            createCheckBox("스키", 1);            //- 1학점
            createCheckBox("스킨스쿠버", 1);       //- 1학점
            createCheckBox("음악힐링", 2);         //- 2학점
            createCheckBox("자기주도적학습법", 3);
            createCheckBox("젠더적시각과뉴미디어체험", 2); //- 2학점
            createCheckBox("진로선택과취업준비", 2); //- 2학점
            createCheckBox("창업제대로하기", 3);
            createCheckBox("취업준비실무", 2);     //- 2학점
            createCheckBox("탁구", 1);           //- 1학점
            createCheckBox("합창", 3);
            createCheckBox("UCC제작과비평", 3);
            createCheckBox("공학과프로그래밍언어", 3);
            createCheckBox("인문.심리치유실습", 3);
            createCheckBox("자율설계교양", 2);     //- 2학점
            createCheckBox("지식경영을위한컴퓨터활용", 3);
            createCheckBox("-------- 학제간 융합 --------", 0);
            createCheckBox("공학과 프로그래밍 언어", 3);
            createCheckBox("지식경영을 위한 컴퓨터활용", 3);
            createCheckBox("UCC제작과비평", 3);
            createCheckBox("도시와인간", 3);
            createCheckBox("인문·심리치유실습", 3);
            createCheckBox("자율설계교양1", 1);    //- 1학점
            createCheckBox("자율설계교양2", 2);     //- 2학점
            createCheckBox("자율설계교양3", 3);
        }
    }
    private void createCheckBox (String option, int scoreChange){
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

                if (isChecked) {
                    score += scoreChange;
                } else {
                    score -= scoreChange;
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
