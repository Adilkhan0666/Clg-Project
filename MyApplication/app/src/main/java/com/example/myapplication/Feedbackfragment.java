package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Feedbackfragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_feedbackfragment, container, false);
        final EditText emailfeedback=view.findViewById(R.id.feedbacemail);
        final EditText subjectfeedback=view.findViewById(R.id.feedbacksubject);
        final EditText messagefeedback=view.findViewById(R.id.feedbackmessage);
        Button submit=view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{emailfeedback.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,subjectfeedback.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,messagefeedback.getText(). toString());

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose app to send mail..."));
            }
        });

        return view;

    }

}
