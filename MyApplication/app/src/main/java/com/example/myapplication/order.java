package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class order extends Fragment {
    int quantity=0;
    View view;
    TextView textView1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_order, container, false);

        final Button add=view.findViewById(R.id.add);
        final TextView textView=view.findViewById(R.id.quantity);
        textView1=view.findViewById(R.id.orderis);

        final CheckBox cb1 = view.findViewById(R.id.channa);
        final CheckBox cb2 =view.findViewById(R.id.dalmakhni);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity=quantity+1;
                textView.setText("Quantity: " + quantity);
            }
        });
        Button sub=view.findViewById(R.id.subtrack);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity=quantity-1;
                textView.setText("Quantity: "+quantity);
            }
        });

        Button orderbutton=view.findViewById(R.id.submitorder);
        orderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean chana=cb1.isChecked();
                boolean dal=cb2.isChecked();

                int price=calulate(chana,dal);
                String message="Channa: "+chana+"\n"+"Dal Makhni: "+dal+"\n"+"total price: "+price;
                textView1.setText(message);

            }
        });
        return view;

    }
    private int calulate(boolean chana, boolean dal) {
        int price=0;
        if (chana){
            price=price+50;
        }
        if (dal){
            price=price+50;
        }
        return quantity*price;
    }
}
