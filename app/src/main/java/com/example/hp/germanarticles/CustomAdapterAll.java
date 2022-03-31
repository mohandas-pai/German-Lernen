package com.example.hp.germanarticles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterAll extends RecyclerView.Adapter<CustomAdapterAll.MyViewHolder> implements Filterable {
    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> newSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewGerman;
        TextView textViewEnglish;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewGerman = (TextView) itemView.findViewById(R.id.textViewGerman);
            this.textViewEnglish = (TextView) itemView.findViewById(R.id.textViewEnglish);
        }


    }

    public CustomAdapterAll(ArrayList<DataModel> data) {
        this.dataSet = data;
        this.newSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewGerman;
        TextView textViewVersion = holder.textViewEnglish;


        textViewName.setText(dataSet.get(listPosition).getGermanName());
        textViewVersion.setText(dataSet.get(listPosition).getEnglishName());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    /*https://stackoverflow.com/questions/30398247/how-to-filter-a-recyclerview-with-a-searchview*/
    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dataSet = (ArrayList<DataModel>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<DataModel> filteredResults = null;
                if (constraint.length() == 0) {
                    filteredResults = newSet;
                } else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }

    protected ArrayList<DataModel> getFilteredResults(String constraint) {
        ArrayList<DataModel> results = new ArrayList<>();

        for (DataModel item : newSet) {
            if ((item.getGermanName().toLowerCase().contains(constraint)) || (item.getEnglishName().toLowerCase().contains(constraint))) {
                results.add(item);
            }
        }
        return results;
    }

}

