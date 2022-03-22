package com.example.hp.germanarticles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private static RecyclerView.Adapter adapter;
    private static CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private String selectedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClickListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.germanArray.length; i++) {
            data.add(new DataModel(
                    MyData.germanArray[i],
                    MyData.englishArray[i],
                    MyData.id_[i]
            ));
        }

        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);

    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Log.d("MOH","Got click why");
            removeItem(v);
        }

        private void removeItem(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewGerman);
            selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < MyData.germanArray.length; i++) {
                if (selectedName.equals(MyData.germanArray[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }

            if(selectedName.equalsIgnoreCase("Possessivpronomen")){

                    Intent intent = new Intent(context, Possesive.class);
                    startActivity(intent);

            }
            else if(selectedName.equalsIgnoreCase("Article Helper")){

                    Intent intent = new Intent(context, ArticleHelper.class);
                    startActivity(intent);

            }
            else if(selectedName.equalsIgnoreCase("Modale Verben")){

                    Intent intent = new Intent(context, ModalVerb.class);
                    startActivity(intent);

            }
            else if(selectedName.equalsIgnoreCase("Präposition")){

                    Intent intent = new Intent(context, Prepositions.class);
                    startActivity(intent);

            }
            else if(selectedName.equalsIgnoreCase("Others/Rules")){

                    Intent intent = new Intent(context, Rules.class);
                    startActivity(intent);

            }
            else if(selectedName.equalsIgnoreCase("Adjektivendungen")){

                    Intent intent = new Intent(context, AdjDecl.class);
                    startActivity(intent);

            }else if (selectedName.equalsIgnoreCase("Präteritum")) {

                Intent intent = new Intent(getApplicationContext(), prateritum.class);
                startActivity(intent);

            }else if(selectedName.equalsIgnoreCase("Adverbs")){

                Intent intent = new Intent(context, AdverbList.class);
                startActivity(intent);

            }else if (selectedName.equalsIgnoreCase("Article Table")) {

                Intent intent = new Intent(getApplicationContext(), ArticleTables.class);
                startActivity(intent);

            }else {

                    Intent intent = new Intent(context, Main2Activity.class);
                    intent.putExtra("name", selectedName);
                    startActivity(intent);

            }
        }
    }


    @Override
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
    }
}
