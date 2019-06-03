package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NoticeActivity extends AppCompatActivity {
    private DatabaseReference fdb;
    private TextView noticeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);


        fdb= FirebaseDatabase.getInstance().getReference().child("Notice");

        noticeTextView=(TextView)findViewById(R.id.display_notice_text);
        fdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue().toString();
                noticeTextView.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
