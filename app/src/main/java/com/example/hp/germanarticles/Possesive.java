package com.example.hp.germanarticles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Possesive extends AppCompatActivity {

    private static CustomAdapter2 adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_possesive);
        myOnClickListener = new Possesive.MyOnClickListener1(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.pgermanArray.length; i++) {
            data.add(new DataModel(
                    MyData.pgermanArray[i],
                    MyData.penglishArray[i]
            ));
        }

        adapter = new CustomAdapter2(data);
        recyclerView.setAdapter(adapter);
    }


    private class MyOnClickListener1 implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener1(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            removeItem1(v);
        }

        private void removeItem1(View v) {
            Log.d("Test","Came to  here Possesive");
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewGerman);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < MyData.pgermanArray.length; i++) {
                if (selectedName.equals(MyData.pgermanArray[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }

            Log.d("Test","Possesive selectedName : "+selectedName);

            Intent intent=new Intent(context,Main2Activity.class);
            intent.putExtra("name", selectedName);
            startActivity(intent);

        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return true;
            }
        });

        return true;
    }*/
}
