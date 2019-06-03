package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    private EditText name,email;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


                name=findViewById(R.id.login_name);
        email=findViewById(R.id.login_emailid);
        login=findViewById(R.id.login_button);


        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String et_name=name.getText().toString();
                String et_email=email.getText().toString();

                if (et_name.equals("Adil") && et_email.equals("adilkhan0666@gmail.com")){
                    startActivity(new Intent(LoginPage.this,AdminNoticePanelActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(LoginPage.this, "Please enter correct credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}