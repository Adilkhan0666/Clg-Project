package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {
    EditText name,email,mobile,password,confirmpassword;
    Button signup,viewdata;
    TextView textView;
    Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectActivity.this,Signup.class);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectActivity.this,Signin.class);
                startActivity(intent);
            }
        });


    }

}
