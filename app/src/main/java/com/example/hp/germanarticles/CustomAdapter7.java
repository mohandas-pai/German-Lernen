package com.example.hp.germanarticles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter7 extends RecyclerView.Adapter<CustomAdapter7.MyViewHolder>{
    private ArrayList<DataModel> dataSet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewGerman;
        TextView textViewEnglish;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewGerman = (TextView) itemView.findViewById(R.id.textViewGerman);
            this.textViewEnglish = (TextView) itemView.findViewById(R.id.textViewEnglish);
        }
    }

    public CustomAdapter7(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(TenseList.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewGerman;
        TextView textViewVersion = holder.textViewEnglish;

        textViewName.setText(dataSet.get(listPosition).getPGermanName());
        textViewVersion.setText(dataSet.get(listPosition).getPEnglishName());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
