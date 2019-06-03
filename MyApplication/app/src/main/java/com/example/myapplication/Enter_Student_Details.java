package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Enter_Student_Details extends AppCompatActivity {

    EditText rollnumber,name,email,idcard,aadhar,placementstatus,studentyear,academicpercentage,totalattendence,backlog;
    Button submit;
    DatabaseReference database;
    String rollnumbers,names,emails,idcards,aadhars,placementstatuss,studentyears,academicpercentages,totalattendences,backlogs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter__student__details);

        database = FirebaseDatabase.getInstance().getReference("AcademicUpdates");

        rollnumber = findViewById(R.id.rollnumberid);
        name = findViewById(R.id.name_id);
        email=findViewById(R.id.email_id);
        idcard=findViewById(R.id.idcardno_id);
        aadhar=findViewById(R.id.adharcard_id);
        placementstatus=findViewById(R.id.placedorunplaced_id);
        studentyear=findViewById(R.id.studentyear_id);
        academicpercentage=findViewById(R.id.totalacademicpercentage_id);
        totalattendence=findViewById(R.id.attendence_id);
        backlog=findViewById(R.id.totalbacklog_id);




        submit = findViewById(R.id.submitattendence);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rollnumbers = rollnumber.getText().toString();
                names=name.getText().toString();
                emails=email.getText().toString();
                idcards=idcard.getText().toString();
                aadhars=aadhar.getText().toString();
                placementstatuss=placementstatus.getText().toString();
                studentyears=studentyear.getText().toString();
                academicpercentages=academicpercentage.getText().toString();
                totalattendences=totalattendence.getText().toString();
                backlogs=backlog.getText().toString();

                HashMap hashMap=new HashMap<String,String>();
                hashMap.put("Name",names+"\n");
                hashMap.put("Email",emails+"\n");
                hashMap.put("Id Card",idcards+"\n");
                hashMap.put("Aadhar",aadhars+"\n");
                hashMap.put("Placement Status",placementstatuss+"\n");
                hashMap.put("Student Year",studentyears+"\n");
                hashMap.put("Academic Percentage",academicpercentages+"\n");
                hashMap.put("Total Attendence",totalattendences+"\n");
                hashMap.put("Backlog",backlogs+"\n");

                database.child(rollnumbers).setValue(hashMap);

                Toast.makeText(Enter_Student_Details.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                rollnumber.setText("");
                name.setText("");
                email.setText("");
                idcard.setText("");
                aadhar.setText("");
                placementstatus.setText("");
                studentyear.setText("");
                academicpercentage.setText("");
                totalattendence.setText("");
                backlog.setText("");


            }
        });



    }
}
