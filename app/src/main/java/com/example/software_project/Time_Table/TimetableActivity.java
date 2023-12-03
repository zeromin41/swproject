package com.example.software_project.Time_Table;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Insert;
import androidx.room.Room;

import com.example.software_project.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TimetableActivity extends AppCompatActivity {
    private TimetableDbHelper dbHelper;

    private ScheduleDatabase db;
    private List<Schedule_Info> scheduleInfos;
    private List<String> subjectList;

    private List<TextView>  textViews;

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1);


        db = Room.databaseBuilder(getApplicationContext(),
                ScheduleDatabase.class, "schedule_db").build();

        textViews = new ArrayList<>();
        thread = new InsertThread();
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //과목리스트생성
        subjectList = addSubject(scheduleInfos);

        LinearLayout linearLayoutContainer = findViewById(R.id.linearLayout_timetable);


        // UI에 데이터 표시
        GridLayout gridLayout = findViewById(R.id.gridlayout_timetable);

        try {
            for (int i = 0; i < scheduleInfos.size(); i++) {
                String day = scheduleInfos.get(i).getDay();
                String time = scheduleInfos.get(i).getTime();
                String subject = scheduleInfos.get(i).getSubject();

                //16:30 - 18:30
                int before_hour_num = Integer.parseInt(time.split("-")[0].split(":")[0]);
                int before_minute_num = Integer.parseInt(time.split("-")[0].split(":")[1]);

                int before_hour = Integer.parseInt(time.split("-")[0].split(":")[0]);
                int before_minute = Integer.parseInt(time.split("-")[0].split(":")[1]);

                int after_hour_num = Integer.parseInt(time.split("-")[1].split(":")[0]);
                int after_minute_num = Integer.parseInt(time.split("-")[1].split(":")[1]);

                // 예제로 TextView를 생성하여 데이터 표시
                //TextView textView = createTimetableTextView(day, time, subject);

                // GridLayout에 TextView 추가
                //addViewToGridLayout(gridLayout, day, time, textView);

                if (before_hour_num == after_hour_num && before_minute_num == after_minute_num) {

                } else {
                    int hour_subtract = (after_hour_num - before_hour_num) * 2;//시간 차이
                    int minute_subtract = (after_minute_num - before_minute_num) / 30;//분 차이

                    int result = hour_subtract + minute_subtract;//span 해야될 row 개수
                    int row = (before_hour_num - 9) * 2 + (before_minute_num == 30 ? 2 : 1);//행번호

                    //병합된 셀들 제거 작업 result수만큼 제거
                    int temp = 0;
                    for (int j = 0; j < result - 1; j++) {
                        String delete_cell_hour = before_minute_num == 30 ? (before_hour_num + 1 < 10 ? "00" + String.valueOf(before_hour_num + 1) : String.valueOf(before_hour_num + 1)) : (before_hour_num < 10 ? "00" + String.valueOf(before_hour_num) : String.valueOf(before_hour_num));

                        before_hour_num = before_minute_num == 30 ? before_hour_num + 1 : before_hour_num;

                        String delete_cell_minute = before_minute_num == 30 ? "00" : "30";

                        before_minute_num = before_minute_num == 30 ? 0 : 30;

                        String delete_cell_name = dayToEnglish(day) + delete_cell_hour + delete_cell_minute;
                        TextView deleteCell = (TextView) gridLayout.findViewWithTag(delete_cell_name);

                        GridLayout gridLayout2 = (GridLayout) gridLayout.findViewById(R.id.gridlayout_timetable);
                        gridLayout2.removeView(deleteCell);
                    }


                    //span해야할 cell의 id
                    String IDofSpanCell = dayToEnglish(day) +  String.format("%02d",before_hour)
                            + String.format("%02d",before_minute);

                    TextView spanCell = (TextView) gridLayout.findViewWithTag(IDofSpanCell);//span cell
                    GridLayout.LayoutParams layoutParams = (GridLayout.LayoutParams)spanCell.getLayoutParams();

                    layoutParams.columnSpec = GridLayout.spec(dayToNum(day));
                    layoutParams.rowSpec = GridLayout.spec(row,result);//병합할 셀 수 정함
                    layoutParams.setGravity(Gravity.FILL);//gravity 설정

                    spanCell.setText(day + "\n" + time + "\n" + subject);

                    spanCell.setTextColor(Color.WHITE);
                    spanCell.setLayoutParams(layoutParams);//적용
                    spanCell.setLayoutParams(layoutParams);//다시 적용

                    spanCell.setBackgroundResource(R.drawable.textview_choose);
                    spanCell.setOnClickListener( v -> {
                        if (v.isSelected()){
                            v.setSelected(false);
                        }else {
                            v.setSelected(true);
                        }
                    });

                    textViews.add(spanCell);
                }

            }
            //체크박스 추가
            for (String subject : subjectList) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(subject);
                // 필요에 따라 CheckBox의 속성을 설정할 수 있습니다.
                checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
                    if (b){
                        //체크설정
                        checkCell(textViews,compoundButton.getText().toString());
                    }else {
                        //체크해제
                        clearcheckCell(textViews,compoundButton.getText().toString());
                    }
                });
                linearLayoutContainer.addView(checkBox);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public int dayToNum(String day)
    {
        if (day.equals("월"))
            return 1;
        else if (day.equals("화"))
            return 2;
        else if (day.equals("수"))
            return 3;
        else if (day.equals("목"))
            return 4;
        else if (day.equals("금"))
            return 5;
        else if (day.equals("토"))
            return 6;
        else if (day.equals("일"))
            return 7;
        else
            return 0;
    }
    String dayToEnglish(String day){
        if (day.equals("월")){
            day = "monday";
        }else if (day.equals("화")){
            day = "tuesday";
        }else if (day.equals("수")){
            day = "wednesday";
        }else if (day.equals("목")){
            day = "thursday";
        }else if (day.equals("금")){
            day = "friday";
        }
        return day;
    }

    void checkCell(List<TextView> list,String sub){
        for(TextView view : list){
            if (view.getText().toString().split("\n")[2].equals(sub)){
                view.setSelected(true);
                int color = ContextCompat.getColor(this, R.color.black);

            }
        }
    }
    void clearcheckCell(List<TextView> list,String sub){
        for(TextView view : list){
            if (view.getText().toString().split("\n")[2].equals(sub)){
                view.setSelected(false);
                view.setTextColor(Color.WHITE);
            }
        }
    }

    List<String> addSubject(List<Schedule_Info> list){

        List<String> infos = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){

            String subject = list.get(i).getSubject();

            // 중복 여부를 확인하고 중복되지 않으면 리스트에 추가
            if (!infos.contains(subject)) {
                infos.add(subject);
            }
        }
        return infos;
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
    class InsertThread extends Thread{
        @Override
        public void run() {

            //데이터베이스에 데이터 추가
            db.ScheduleDao().insertUserInfo(new Schedule_Info("월", "15:30-16:30", "데이터베이스"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("화", "14:00-16:00", "데이터베이스"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("화", "09:30-11:00", "운영체제"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("목", "09:30-11:00", "운영체제"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("목", "16:00-18:00", "컴퓨터그래픽스"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("금", "11:00-12:00", "컴퓨터그래픽스"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("월", "16:30-18:00", "소프트웨어공학"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("수", "14:30-16:00", "소프트웨어공학"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("수", "11:30-14:30", "융합소프트웨어프로젝트"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("월", "13:30-15:00", "딥러닝"));
            db.ScheduleDao().insertUserInfo(new Schedule_Info("화", "16:30-18:00", "딥러닝"));

            scheduleInfos = db.ScheduleDao().getAll();

            super.run();
        }
    }
}

