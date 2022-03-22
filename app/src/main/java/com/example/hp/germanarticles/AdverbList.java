package com.example.hp.germanarticles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AdverbList extends AppCompatActivity {

    private static CustomAdapter5 adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverb_list);
        myOnClickListener = new MyOnClickListener2(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view3);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.adverbG.length; i++) {
            data.add(new DataModel(
                    MyData.adverbG[i],
                    MyData.adverbE[i]
            ));
        }
        adapter = new CustomAdapter5(data);
        recyclerView.setAdapter(adapter);

    }
    private class MyOnClickListener2 implements View.OnClickListener {

        private final Context context;


        private MyOnClickListener2(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Log.d("Test","Came to  here MyOnClickListener2");
            removeItem1(v);
        }

        private void removeItem1(View v) {
            Log.d("Test", "Came to  here ArticleHelper");
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewGerman);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < MyData.adverbG.length; i++) {
                if (selectedName.equals(MyData.adverbG[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }
            Log.d("Test", "ArticleHelper selectedName : " + selectedName);

            if(selectedName.equalsIgnoreCase("Comparative and Superlative")) {
                Intent intent = new Intent(context, TextActivity.class);
                intent.putExtra("name", selectedName);
                startActivity(intent);
            } else {
                Intent intent = new Intent(context, Adverbs.class);
                intent.putExtra("name", selectedName);
                startActivity(intent);
            }

        }
    }
}