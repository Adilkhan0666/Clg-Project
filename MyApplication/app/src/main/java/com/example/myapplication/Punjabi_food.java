package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Punjabi_food extends Fragment {
    public String arr2[] = {String.valueOf(R.drawable.channa), String.valueOf(R.drawable.dal_makhni),
            String.valueOf(R.drawable.chole_bhature), String.valueOf(R.drawable.fish_tikka_amritsari),
            String.valueOf(R.drawable.murgh_malai), String.valueOf(R.drawable.paneer_tikka),
            String.valueOf(R.drawable.saag), String.valueOf(R.drawable.dhaba_dal), String.valueOf(R.drawable.lassi),
            String.valueOf(R.drawable.dal_chawal), String.valueOf(R.drawable.full_thali_1), String.valueOf(R.drawable.deluxe_thali),
            String.valueOf(R.drawable.rich_thali)};
    public String arr1[] = {"Channa", "Dal Makhni", "Chole Bhature", "Fish Tikka Amritsari", "Murgh Malai", "Paneer Tikka", "Saag",
            "Dhaba Dal", "Lassi", "Dal Chawal", "Full Thali 1", "Full Thali 2", "Rich Thali"};

    public String pricefoodarr[] = {"50rs", "150rs", "100rs", "300rs", "280rs", "250rs", "250rs", "150rs", "80rs", "140rs", "200rs", "250rs", "450rs"};
    adapter adapter = new adapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_punjabi_food, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;


//        return inflater.inflate(R.layout.fragment_punjabi_food, container, false);
    }

    class adapter extends RecyclerView.Adapter<adapter.myview> {

        @Override
        public myview onCreateViewHolder(ViewGroup parent, int viewType) {
            View vv = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
            return new myview(vv);
        }

        @Override
        public void onBindViewHolder(myview holder, int position) {
            holder.tv1.setText("Name: " + arr1[position]);
            holder.tv3.setText("Price: " + pricefoodarr[position]);
            holder.tv2.setImageResource(Integer.parseInt(arr2[position]));
        }

        @Override
        public int getItemCount() {
            return arr1.length;

        }

        class myview extends RecyclerView.ViewHolder {
            TextView tv1, tv3;
            ImageView tv2;

            public myview(View vv) {
                super(vv);
                tv1 = vv.findViewById(R.id.tv1);
                tv2 = vv.findViewById(R.id.iv1);
                tv3 = vv.findViewById(R.id.priceoffood);
            }
        }
    }
}
