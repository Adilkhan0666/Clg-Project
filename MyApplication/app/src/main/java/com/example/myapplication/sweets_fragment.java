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

public class sweets_fragment extends Fragment {

    public String arr2[] = {String.valueOf(R.drawable.dhoklaa),
            String.valueOf(R.drawable.laddu),
            String.valueOf(R.drawable.chum_chum),
            String.valueOf(R.drawable.gulam_jamun),
            String.valueOf(R.drawable.ghevar),
            String.valueOf(R.drawable.kajukatli),
            String.valueOf(R.drawable.rasgulla),
            String.valueOf(R.drawable.rasmalai),
            String.valueOf(R.drawable.soan_papdi),
            String.valueOf(R.drawable.sohanhalwa),};

    public String arr1[] =       {"Dhokla","Laddu","Chum Chum","Gualb Jamun","Ghevar","Kaju Katli","Rasgulla","Rasmalai","Soan Papdi","Sohan Halwa"};
    public String pricefoodarr[]={"50rs"  ,"20rs","70rs"    ,"50rs"      ,"100rs" ,"30rs"     ,"30rs"   ,"80rs"   ,"40rs"      ,"70rs"};
    adaptersweet adaptersweet=new adaptersweet();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sweets_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.sweetrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaptersweet);
        return view;
    }
    class adaptersweet extends RecyclerView.Adapter<sweets_fragment.adaptersweet.mySweetviews> {
        @Override
        public mySweetviews onCreateViewHolder(ViewGroup parent, int viewType) {
            View vv= LayoutInflater.from(parent.getContext()).inflate(R.layout.sweet_layout,parent,false);
            return new mySweetviews(vv);
        }
        @Override
        public void onBindViewHolder(mySweetviews holder, int position) {
            holder.tv3.setText("Name: "+arr1[position]);
            holder.tv4.setText("Price per pc: "+pricefoodarr[position]);
            holder.tv2.setImageResource(Integer.parseInt(arr2[position]));
        }
        @Override
        public int getItemCount() {
            return arr2.length;
        }
        class mySweetviews extends RecyclerView.ViewHolder {
            ImageView tv2;
            TextView tv3,tv4;
            public mySweetviews(View vv) {
                super(vv);
                tv2=vv.findViewById(R.id.sweetimages);
                tv3=vv.findViewById(R.id.sweettext);
                tv4=vv.findViewById(R.id.priceofsweets);

            }
        }
    }
}