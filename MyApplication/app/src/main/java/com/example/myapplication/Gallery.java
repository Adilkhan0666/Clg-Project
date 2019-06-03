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


public class Gallery extends Fragment {
    public String arr2[] = {String.valueOf(R.drawable.one), String.valueOf(R.drawable.two),
            String.valueOf(R.drawable.three), String.valueOf(R.drawable.four),
            String.valueOf(R.drawable.five), String.valueOf(R.drawable.six),
            String.valueOf(R.drawable.seven), String.valueOf(R.drawable.eight),
            String.valueOf(R.drawable.nine)};


    adapter adapter = new adapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gallery, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recgallery);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }
    class adapter extends RecyclerView.Adapter<adapter.myview> {

        @Override
        public myview onCreateViewHolder(ViewGroup parent, int viewType) {
            View vv= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallerylayoutfolder,parent,false);
            return new myview(vv);
        }

        @Override
        public void onBindViewHolder(myview holder, int position) {
            holder.tv2.setImageResource(Integer.parseInt(arr2[position]));
        }

        @Override
        public int getItemCount() {
            return arr2.length;

        }

        class myview extends RecyclerView.ViewHolder {
            ImageView tv2;

            public myview(View vv) {
                super(vv);
                tv2=vv.findViewById(R.id.galleryimages);
            }
        }
    }
}

