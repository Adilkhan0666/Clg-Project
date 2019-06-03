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

import java.util.jar.Attributes;

public class AcademicUpdates extends AppCompatActivity {
    private DatabaseReference fdb;
    TextView academic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_updates);


        fdb = FirebaseDatabase.getInstance().getReference().child("AcademicUpdates");
        academic = findViewById(R.id.academic_view);



        fdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String Backlog = snapshot.child("Backlog").getValue().toString();
                    String Email = snapshot.child("Email").getValue().toString();
                    String Name = snapshot.child("Name").getValue().toString();
                    String Aadhar = snapshot.child("Aadhar").getValue().toString();
                    String Idcard= snapshot.child("Id Card").getValue().toString();
                    String Placementstatus = snapshot.child("Placement Status").getValue().toString();
                    String Academicpercentage= snapshot.child("Academic Percentage").getValue().toString();
                    String TotalAttendence = snapshot.child("Total Attendence").getValue().toString();
                    String Studentyear = snapshot.child("Student Year").getValue().toString();

                    academic.setText("Name: "+Name+"\n"+
                            "Email: "+Email+"\n"+
                            "Idcard: "+Idcard+"\n"+
                            "Total Attendence: "+TotalAttendence+"\n"+
                            "Academic Percentage: "+Academicpercentage+"\n"+
                            "Student Year: "+Studentyear+"\n"+
                            "Placement Status: "+Placementstatus+"\n"+
                            "Backlog:" +Backlog+"\n"+
                            "Aadhar: "+Aadhar);
                }
                //String s=dataSnapshot.getValue().toString();

                //academic.setText();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
