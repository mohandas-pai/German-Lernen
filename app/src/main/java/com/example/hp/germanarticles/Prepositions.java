package com.example.hp.germanarticles;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Prepositions extends AppCompatActivity {


    /*wordArray = new String[]{"Durch\t\t(Through)","Ohne\t\t(Without)","Gegen\t\t(Against)","für\t\t(For)","um\t\t(At/Around)","bis\t\t(Until/Till)","Entlang\t\t(Alongside)"};
                    "mich,dich,ihn,sie,es,uns,euch,sie,Sie\n\nden,die,das,die\neinen,eine,ein\nkeinen,keine,kein,keine\n" +
                                    "\nmeinen,meine,mien,meine\n" +
                                    "deinen,deine,dien,deine\n" +
                                    "seinen,seine,sien,seine\n" +
                                    "ihren,ihre,ihr,ihre\n" +
                                    "unseren,unsere,unser,unsere\n" +
                                    "euren,eure,euer,eure\n


    wordArray = new String[]{"aus\t\t(From)","Außer\t\t(Except)","bei\t\t(At/With/From)","mit\t\t(With)","seit\t\t(Since)","nach\t\t(After/To)","von\t\t(Of/By/From)","zu\t\t(At/To)","ab\t\t(From)","Gegenüber\t\t(Opposite To)"};
    "mir,dir,ihm,ihr,ihm,uns,euch,ihnen,\nihnen\n\n" +
                                    "dem,der,dem,den+n\n" +
                                    "einem,einer,einem\n" +
                                    "keinem,keiner,keinem,keinen+n\n\n" +
                                    "meinem,meiner,meinem,meinen+n\n" +
                                    "deinem,deiner,deinem,deinen+n\n" +
                                    "seinem,seiner,seinem,seinen+n\n" +
                                    "ihrem,ihrer,ihrem,ihren+n\n" +
                                    "unserem,unserer,unserem,unseren+n\n" +
                                    "eurem,eurer,eurem,euren+n"

    in\t\t(in)","an\t\t(on(vertical))","auf\t\t(on(horizontal))","unter\t\t(Below)","hinter\t\t(Behind)","neben\t\t(Near To/Next To)","zwischen\t\t(Between)","vor\t\t(In Front Of)","über\t\t(Above/Over)"};

    */

    private static CustomAdapter6 adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepositions);
        myOnClickListener = new MyOnClickListener2(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.PrepG.length; i++) {
            data.add(new DataModel(
                    MyData.PrepG[i],
                    MyData.PrepE[i]
            ));
        }
        adapter = new CustomAdapter6(data);
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
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewGerman);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < MyData.PrepG.length; i++) {
                if (selectedName.equals(MyData.PrepG[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }

            if(selectedName.equalsIgnoreCase("'Da' mit Präpositionen")){
                Intent intent = new Intent(context, TextActivity.class);
                intent.putExtra("name", selectedName);
                startActivity(intent);
            }else{
                Intent intent = new Intent(context, Adverbs.class);
                intent.putExtra("name", selectedName);
                startActivity(intent);
            }




        }
    }

}