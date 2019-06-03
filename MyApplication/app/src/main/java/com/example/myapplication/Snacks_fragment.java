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


public class Snacks_fragment extends Fragment {
    public String arr2[] = {String.valueOf(R.drawable.tea),
            String.valueOf(R.drawable.coffee),
            String.valueOf(R.drawable.burger),
            String.valueOf(R.drawable.chilli_potato),
            String.valueOf(R.drawable.dahi_bhalla),
            String.valueOf(R.drawable.gol_gappe),
            String.valueOf(R.drawable.momos),
            String.valueOf(R.drawable.noodles),
            String.valueOf(R.drawable.pasta),
            String.valueOf(R.drawable.pav_bhaji),
            String.valueOf(R.drawable.raj_kachori),
            String.valueOf(R.drawable.samosa),
            String.valueOf(R.drawable.springrolls),
            String.valueOf(R.drawable.stuffedbreadpakora),
            String.valueOf(R.drawable.cans),
            String.valueOf(R.drawable.redbul)};

    public String arr1[] =       {"Tea","Coffee","Burger","Chilli Potato","Dahi Bhalla","Gol Gappe","Momos","Noodles","Pasta","Pav Bhaji","Raj Kachori","Samosa","Spring Roll","Bread Pakora","Cold Drinks","Red Bull"};
    public String pricefoodarr[]={"50rs","80rs" ,"70rs"  ,"100rs"         ,"50rs"       ,"15rs"    ,"90rs" ,"70rs"   ,"120rs" ,"100rs"     ,"150rs"       ,"30rs"  ,"130rs"       ,"50rs"         ,"70rs"     ,"130rs"};
    adaptersnack adaptersnack=new adaptersnack();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_snacks_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.snackrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaptersnack);
        return view;

//        return inflater.inflate(R.layout.fragment_snacks_fragment, container, false);
    }
    class adaptersnack extends RecyclerView.Adapter<Snacks_fragment.adaptersnack.myviews> {

        @Override
        public Snacks_fragment.adaptersnack.myviews onCreateViewHolder(ViewGroup parent, int viewType) {
            View vv= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_snack_layout,parent,false);
            return new myviews(vv);
        }

        @Override
        public void onBindViewHolder(Snacks_fragment.adaptersnack.myviews holder, int position) {
            holder.tv3.setText("Name: "+arr1[position]);
            holder.tv4.setText("Price per item: "+pricefoodarr[position]);
            holder.tv2.setImageResource(Integer.parseInt(arr2[position]));
        }

        @Override
        public int getItemCount() {
            return arr2.length;
        }

        class myviews extends RecyclerView.ViewHolder {
            ImageView tv2;
            TextView tv3,tv4;
            public myviews(View vv) {
                super(vv);

                tv2=vv.findViewById(R.id.snackimage);
                tv3=vv.findViewById(R.id.snacktextview);
                tv4=vv.findViewById(R.id.priceofsnack);

            }
        }
    }
}

