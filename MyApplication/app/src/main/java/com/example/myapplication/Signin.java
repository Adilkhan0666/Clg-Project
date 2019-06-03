package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    TextInputEditText enteremail,enterpassword;
    Button signin;
    databasehelper dh;
    TextView forgetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        dh=new databasehelper(this);


        enteremail = findViewById(R.id.loginemail);
        enterpassword = findViewById(R.id.enterpassword);
        signin = findViewById(R.id.signin);

//        forgetpassword=findViewById(R.id.forgetpassword);
//
//        forgetpassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Signin.this,forgetpassword.class);
//                startActivity(intent);
//            }
//        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = enteremail.getText().toString();
                String s2 = enterpassword.getText().toString();

                Boolean checkmailpass = dh.emailpassword(s1, s2);
                if (checkmailpass == true) {
                    Toast.makeText(Signin.this, "Log in success", Toast.LENGTH_SHORT).show();
                    enteremail.setText("");
                    enterpassword.setText("");
                    Intent i=new Intent(Signin.this,CanteenNavigationActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Signin.this, "Log in failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
