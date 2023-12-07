package com.example.software_project.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.software_project.R;

public class Join_Activity extends AppCompatActivity {

    Button btn_close, btn_login;

    EditText et_id, et_pass, et_name, et_email;

    String id, pw, name, email;

    private User_Database db;

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        // Room 데이터베이스 초기화
        db = Room.databaseBuilder(getApplicationContext(),
                User_Database.class, "userinfo_db").build();

        btn_close = findViewById(R.id.btn_close);
        btn_login = findViewById(R.id.btn_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);

        thread = new InsertThread();

        btn_login.setOnClickListener(v -> {
            id = et_id.getText().toString();
            pw = et_pass.getText().toString();
            name = et_name.getText().toString();
            email = et_email.getText().toString();

            if (id.isEmpty() || pw.isEmpty() || name.isEmpty() || email.isEmpty()) {
                Toast.makeText(getApplicationContext(), "정보를 전부 입력해주세요!", Toast.LENGTH_SHORT).show();
                return;
            }

            // 아이디가 숫자로만 구성되어 있는지 확인
            if (!id.matches("\\d+")) {
                Toast.makeText(getApplicationContext(), "아이디는 숫자로만 구성되어야 합니다 (학번)!", Toast.LENGTH_SHORT).show();
                return;
            }

            // 이메일이 올바른 형식인지 확인
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(getApplicationContext(), "올바른 이메일 형식이 아닙니다!", Toast.LENGTH_SHORT).show();
                return;
            }

            // 나머지 코드는 그대로 유지합니다
            try {
                thread.start();
                thread.join();
                Toast.makeText(getApplicationContext(), "회원가입 완료!", Toast.LENGTH_SHORT).show();
                finish();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // Room 데이터베이스에 사용자 정보를 삽입하는 스레드
    class InsertThread extends Thread {
        @Override
        public void run() {
            db.UserDaoDao().insertUserInfo(new User_Info(id, pw, name, email));
            super.run();
        }
    }
}
