package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    databasehelper dh;
    Button signup, emailpass, delete, signin;
    EditText email, password, cpassword, name, mobile;
    TextView surname;
    String s1, s2, s3, s4, s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dh = new databasehelper(this);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        Button skip=findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup.this,CanteenNavigationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = email.getText().toString();
                s2 = password.getText().toString();
                s3 = cpassword.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(Signup.this, "fill please", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean chkmail = dh.checkemail(s1);
                        if (chkmail == true) {
                            Boolean insert = dh.inssert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(Signup.this, "success insert", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        } else {
                            Toast.makeText(Signup.this, "email alreay exixt", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "password do not matched", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                }
            }
        });
    }
}