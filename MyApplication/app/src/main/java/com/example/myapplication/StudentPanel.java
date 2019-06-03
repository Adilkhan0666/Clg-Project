package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_panel);

        TextView notice_textView=(TextView)findViewById(R.id.notice_textView);
        TextView uptu_circulars=(TextView)findViewById(R.id.attendence_textView);
        TextView placementUpdate_textView=(TextView)findViewById(R.id.placementUpdate_textView);
        TextView academicUpdate_textView=(TextView)findViewById(R.id.academicUpdate_textView);
        TextView keccanteen_textView=(TextView)findViewById(R.id.keccanteen_textView);
        TextView akturesult=(TextView)findViewById(R.id.aktu_result);



        notice_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentPanel.this,NoticeActivity.class);
                startActivity(intent);
            }
        });

        academicUpdate_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentPanel.this,AcademicUpdates.class);
                startActivity(intent);
            }
        });

        uptu_circulars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentPanel.this,UptuCircular.class));
            }
        });

        placementUpdate_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentPanel.this,PlacementUpdateActiviy.class);
                startActivity(intent);
            }
        });

        keccanteen_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(StudentPanel.this,SelectActivity.class));
            }
        });

        akturesult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentPanel.this,AktuResult.class));
            }
        });
    }
}
