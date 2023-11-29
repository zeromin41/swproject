package com.example.software_project.Drawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.software_project.R;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class SchoolInfo_Activity extends AppCompatActivity {

    Button mbtn_url;
    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        setTitle("학교정보");

        mbtn_url = findViewById(R.id.btn_url);

        a = findViewById(R.id.btn_url2);

        mbtn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hknu.ac.kr"));
                startActivity(urlintent);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?where=nexearch&sm=tab_etc&mra=bksw&pkid=50&os=619475&qvt=0&query=%ED%95%9C%EA%B2%BD%EA%B5%AD%EB%A6%BD%EB%8C%80%ED%95%99%EA%B5%90"));
                startActivity(urlintent);
            }
        });


    }
}
