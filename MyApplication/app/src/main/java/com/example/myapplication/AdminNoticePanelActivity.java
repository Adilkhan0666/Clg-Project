package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminNoticePanelActivity extends AppCompatActivity {
    EditText editText_name;
    Button submit,enterstudentdetail;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notice_panel);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        editText_name = findViewById(R.id.adminNoticePanel_editText);
        submit = findViewById(R.id.adminNoticePanel_clickButton);

        findViewById(R.id.enter_student_details_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminNoticePanelActivity.this,Enter_Student_Details.class));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //HashMap<String,String> hashMap=new HashMap<>();
                String s = editText_name.getText().toString();
                // hashMap.put("notice",s);
                mDatabase.child("Notice").setValue(s);

                Toast.makeText(AdminNoticePanelActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                editText_name.setText("");

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.facultymenus, menu);
        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if (id== R.id.logout){
            startActivity(new Intent(AdminNoticePanelActivity.this, MainActivity.class));
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}