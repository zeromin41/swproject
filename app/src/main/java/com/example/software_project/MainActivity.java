package com.example.software_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.software_project.Drawer.JobInfo_Activity;
import com.example.software_project.Drawer.Profile_Activity;
import com.example.software_project.Drawer.SchoolInfo_Activity;
import com.example.software_project.Login.Login_Activity;
import com.example.software_project.UI.Frag1;
import com.example.software_project.UI.Frag2;
import com.example.software_project.UI.Frag3;
import com.example.software_project.UI.Frag4;
import com.example.software_project.UI.Frag5;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    public static final int SUBJECT_REQUEST_CODE = 1;  // 이 값을 정의합니다.

    private void performCommonTask() {  // 공통 작업 수행
    }

    private DrawerLayout drawerLayout;
    private View drawerView;

    private BottomNavigationView bottomNavigationView;  //바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Login_Activity login_activity; // 로그인 프래그먼트
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag4 frag4;
    private Frag3 frag3;
    private Frag5 frag5;

    private Switch darkModeSwitch;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        performCommonTask();

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        NavigationView navigationView = findViewById(R.id.Main_Info);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(MainActivity.this, Profile_Activity.class); // 예시 클래스, 실제 클래스로 변경 필요
                        startActivity(intent);
                        break;

                    case R.id.nav_school: // nav_profile이라는 id를 가진 메뉴 항목에 대한 처리
                        intent = new Intent(MainActivity.this, SchoolInfo_Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_job:
                        intent = new Intent(MainActivity.this, JobInfo_Activity.class);
                        startActivity(intent);
                        break;

                    /*case R.id.nav_job_info:
                        intent = new Intent(MainActivity.this, JobInfoActivity.class);
                        startActivity(intent);
                        break;*/

                    // 추가하고 싶은 다른 메뉴 항목들에 대한 처리를 이곳에 추가할 수 있습니다.

                    default:
                        return false;
                }
                drawerLayout.closeDrawers(); // 메뉴 항목을 클릭한 후에는 드로어를 닫아줍니다.
                return true;
            }
        });

        darkModeSwitch = findViewById(R.id.darkModeSwitch);

        // 현재 다크 모드 상태를 확인하여 Switch 상태 초기화
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);
        darkModeSwitch.setChecked(isDarkMode);

        // 다크 모드 토글 리스너 설정
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                sharedPreferences.edit().putBoolean("isDarkMode", true).apply();
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                sharedPreferences.edit().putBoolean("isDarkMode", false).apply();
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_time:
                        setFrag(0);
                        break;
                    case R.id.action_edit:
                        setFrag(1);
                        break;
                    case R.id.action_home:
                        setFrag(2);
                        break;
                    case R.id.action_radar:
                        setFrag(3);
                        break;
                    case R.id.action_reorder:
                        setFrag(4);
                        break;

                }
                return true;
            }
        });
        login_activity= new Login_Activity();
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();

        setLogin_activity();  //첫 프레그먼트 화면을 무엇으로 지정해 줄 것인지 선택.

    }
    private void setLogin_activity() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, login_activity)
                .commit();

        // 바텀 네비게이션 다시 표시
        /*BottomNavigationView bottomNav = findViewById(R.id.bottomNavi);
        if (bottomNav != null) {
            bottomNav.setVisibility(View.VISIBLE);
        }*/
    }
    public void onLoginSuccess() {
        setFrag(0);

        // 바텀 네비게이션 다시 표시
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavi);
        if (bottomNav != null) {
            bottomNav.setVisibility(View.VISIBLE);
        }
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
    //프레그먼트 교체가 일어나는 실행문
    private  void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame, frag5);
                ft.commit();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // SharedPreferences에서 데이터 로드
        SharedPreferences sharedPreferences = getSharedPreferences("ProfileInfo", MODE_PRIVATE);
        String photoUriStr = sharedPreferences.getString("PhotoUri", "");
        String name = sharedPreferences.getString("Name", "_____");
        String studentNumber = sharedPreferences.getString("StudentNumber", "__________");
        String birthDate = sharedPreferences.getString("BirthDate", "________");

        // 드로어 레이아웃의 ImageView에 사진 표시
        if (!photoUriStr.equals("")) {
            ImageView profileImageView = findViewById(R.id.imageView);
            profileImageView.setImageURI(Uri.parse(photoUriStr));
        }

        // 드로어 레이아웃의 TextView에 정보 표시
        // 예를 들어, drawerLayout에 이름, 학번, 생년월일을 표시하는 TextView가 있다고 가정합니다.
        TextView nameTextView = drawerLayout.findViewById(R.id.textView26);
        TextView studentNumberTextView = drawerLayout.findViewById(R.id.textView27);
        TextView birthDateTextView = drawerLayout.findViewById(R.id.textView28);

        nameTextView.setText(name);
        studentNumberTextView.setText(studentNumber);
        birthDateTextView.setText(birthDate);
    }

}