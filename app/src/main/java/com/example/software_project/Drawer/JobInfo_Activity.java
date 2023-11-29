package com.example.software_project.Drawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.software_project.R;

public class JobInfo_Activity extends AppCompatActivity {

    Button mbtn_url;
    Button a;
    Button b;
    Button c;
    Button d;

    Button e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        setTitle("취업정보");

        mbtn_url = findViewById(R.id.btn_url);

        a = findViewById(R.id.btn_url2);
        b = findViewById(R.id.btn_url3);
        c = findViewById(R.id.btn_url4);
        d = findViewById(R.id.btn_url5);
        e = findViewById(R.id.btn_url6);

        mbtn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://programmers.co.kr/"));
                startActivity(urlintent);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jobplanet.co.kr/job"));
                startActivity(urlintent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldjob.or.kr/new_index.do"));
                startActivity(urlintent);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.work.go.kr/seekWantedMain.do"));
                startActivity(urlintent);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://job.alio.go.kr/main.do"));
                startActivity(urlintent);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ncs.go.kr/index.do"));
                startActivity(urlintent);
            }
        });


    }
}
