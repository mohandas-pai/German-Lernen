package com.example.hp.germanarticles;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Adverbs extends AppCompatActivity {

    TextView txtHeading;
    String name;
    String english[],german[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverbs);

        txtHeading = (TextView)findViewById(R.id.headingText);

        Bundle b;
        b = getIntent().getExtras();
        name = b.getString("name");

        txtHeading.setText(name);

        setdataBasedOnHeading();
        addHeaders();
        addData();
    }

    private void setdataBasedOnHeading() {
        if(name.equalsIgnoreCase("Adverbs of Time")) {

            english = new String[]{"Today","Tomorrow","Day after Tomorrow","Yesterday","Tomorrow Morning","Soon",
                    "Now","Earlier","Later","First","Since Then","Back then","Ever",
                    "Just","Nowadays","Always","For Years","Until Now","Never"};
            german = new String[]{"Heute", "Morgen", "Übermorgen", "Gestern","Morgen früh","Bald","Jetzt",
                    "Früher", "Später", "Zuerst", "Seitdem","Damals","Jemals","Eben",
                    "Heutzutage", "Immer", "Jahrelang", "Bisher","Nie/Niemals"};

        }else if(name.equalsIgnoreCase("Adverbs of Place")) {

            english = new String[]{"Here","There","Left","Right","Up","Down",
                    "In Front Of","Behind","Everywhere","Nowhere","Anywhere"};
            german = new String[]{"Hier", "Dort", "Links", "Rechts","Oben","Unten","Vorne",
                    "Hinten", "Überall", "Nirgends","Irgendwo"};

        }else if(name.equalsIgnoreCase("Quantifiers")) {

            english = new String[]{"Very","Quite, Completely","Really","Totally","Absolutely","Quite, Fairly",
                    "Especially","Too, Excessively","A Litte",};
            german = new String[]{"Sehr", "Ganz", "Echt/Wirklich", "Total","Absolut","Ziemlich",
                    "Besonders", "Zu", "Ein bisschen"};

        }
        else if(name.equalsIgnoreCase("Präpositionen mit Akkustiv")) {
            english = new String[]{"Through","Without, Against","For","At/Around","Until/Till","Alongside"};
            german = new String[]{"Durch", "Ohne", "Gegen", "für","um","bis", "Entlang"};

        }else if(name.equalsIgnoreCase("Präpositionen mit Dativ")) {
            english = new String[]{"From","Except", "At/With/From","With","Since","After/To",
                    "Of/By/From","At/To","From","Opposite To"};
            german = new String[]{"aus", "Außer", "bei", "mit","seit","nach",
                    "von", "Zu", "ab", "Gegenüber"};

        }else if(name.equalsIgnoreCase("Wechseln Präpositionen")) {
            english = new String[]{"in","on(vertical)","on(horizontal)","Below","Behind","Near To/Next To",
                    "Between","In Front Of","Above/Over",};
            german = new String[]{"in", "an", "auf", "Total","unter","hinter",
                    "neben", "zwischen", "vor","über"};

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
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    public void addHeaders() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Adverb", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "Meaning", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tl.addView(tr, getTblLayoutParams());
    }

    /**
     * This function add the data to the table
     **/
    public void addData() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < english.length; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, german[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, english[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }
}