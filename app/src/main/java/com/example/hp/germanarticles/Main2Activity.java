package com.example.hp.germanarticles;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends AppCompatActivity {


    TextView txtHeading;
    String name;

    String mas[],fem[],neu[],plr[],row[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Bundle b;
        b = getIntent().getExtras();
        name = b.getString("name");

        txtHeading = (TextView)findViewById(R.id.headingText);

        txtHeading.setText(name);

        row = new String[]{"NOM", "AKK", "DAT", "GEN"};
        setdataBasedOnHeading(name);
        addHeaders();
        addData();
    }

    private void setdataBasedOnHeading(String name) {
        if(name.equalsIgnoreCase("bestimmter Artikel")) {
            mas = new String[]{"der", "den", "dem", "des"};
            fem = new String[]{"die", "die", "der", "der"};
            neu = new String[]{"das", "das", "dem", "des"};
            plr = new String[]{"die", "die", "den+n", "der"};
        }
        else if(name.equalsIgnoreCase("unbestimmter Artikel")){
            mas = new String[]{"ein", "einen", "einem", "eines"};
            fem = new String[]{"eine", "eine", "einer", "einer"};
            neu = new String[]{"ein", "ein", "einem", "eines"};
            plr = new String[]{"-", "-", "-", "-"};
        }
        else if(name.equalsIgnoreCase("Negationsartikel")){
            mas = new String[]{"kein", "keinen", "keinem", "keines"};
            fem = new String[]{"keine", "keine", "keiner", "keiner"};
            neu = new String[]{"kein", "kein", "keinem", "keines"};
            plr = new String[]{"keine", "keine", "keinen+n", "keiner"};
        }
        else if(name.equalsIgnoreCase("mein")){
            mas = new String[]{"mein", "meinen", "meinem", "meines"};
            fem = new String[]{"meine", "meine", "meiner", "meiner"};
            neu = new String[]{"mein", "mein", "meinem", "meines"};
            plr = new String[]{"meine", "meine", "meinen+n", "meiner"};
        }
        else if(name.equalsIgnoreCase("sein")){
            mas = new String[]{"sein", "seinen", "seinem", "seines"};
            fem = new String[]{"seine", "seine", "seiner", "seiner"};
            neu = new String[]{"sein", "sein", "seinem", "seines"};
            plr = new String[]{"seine", "seine", "seinen+n", "seiner"};
        }
        else if(name.equalsIgnoreCase("dein")){
            mas = new String[]{"dein", "deinen", "deinem", "deines"};
            fem = new String[]{"deine", "deine", "deiner", "deiner"};
            neu = new String[]{"dein", "dein", "deinem", "deines"};
            plr = new String[]{"deine", "deine", "deinen+n", "deiner"};
        }
        else if(name.equalsIgnoreCase("ihr")){
            mas = new String[]{"ihr", "ihren", "ihrem", "ihrs"};
            fem = new String[]{"ihre", "ihre", "ihrer", "ihrer"};
            neu = new String[]{"ihr", "ihr", "ihrem", "ihrs"};
            plr = new String[]{"ihre", "ihre", "ihren+n", "ihrer"};
        }
        else if(name.equalsIgnoreCase("unser")){
            mas = new String[]{"unser", "unsern", "unserm", "unsers"};
            fem = new String[]{"unsere", "unsere", "unserer", "unserer"};
            neu = new String[]{"unser", "unsere", "unserem", "unsers"};
            plr = new String[]{"unsere", "unsere", "unseren+n", "unserer"};
        }
        else if(name.equalsIgnoreCase("euer")){
            mas = new String[]{"euer", "euren", "eurem", "eures"};
            fem = new String[]{"eure", "eure", "eurer", "eurer"};
            neu = new String[]{"euer", "euer", "eurem", "eures"};
            plr = new String[]{"eure", "eure", "euren+n", "eures"};
        }
    }

    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        final TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());

        return tv;
    }

    @NonNull
    private LayoutParams getLayoutParams() {
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
    }

    /**
     * This function add the headers to the table
     **/
    public void addHeaders() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "MAS", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "FEM", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "NEU", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "PLR", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tl.addView(tr, getTblLayoutParams());
    }

    /**
     * This function add the data to the table
     **/
    public void addData() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < 4; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, row[i], Color.WHITE, Typeface.BOLD,  ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, mas[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 3, fem[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 4, neu[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 5, plr[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }


}
