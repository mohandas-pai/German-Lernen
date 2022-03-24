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

public class VerbList extends AppCompatActivity {

    private static CustomAdapter8 adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb_list);
        myOnClickListener = new VerbList.MyOnClickListener2(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view3);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.verbG.length; i++) {
            data.add(new DataModel(
                    MyData.verbG[i],
                    MyData.verbE[i]
            ));
        }
        adapter = new CustomAdapter8(data);
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
            for (int i = 0; i < MyData.verbG.length; i++) {
                if (selectedName.equals(MyData.verbG[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }

            Intent intent = new Intent(context, Adverbs.class);
            intent.putExtra("name", selectedName);
            startActivity(intent);

        }
    }
}