package com.example.hp.germanarticles;


import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    TextView txtHeading,txt;
    String name;
    String word[],comp[],sup[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        txtHeading = (TextView)findViewById(R.id.headingText);
        txt = (TextView)findViewById(R.id.txt);

        Bundle b;
        b = getIntent().getExtras();
        name = b.getString("name");

        txtHeading.setText(name);

        setdataBasedOnHeading(name);
    }

    private void setdataBasedOnHeading(String name) {
        String sourceString = "";
        if(name.equalsIgnoreCase("Comparative and Superlative")){
            sourceString = "-> Comparatives in German are made by adding <b>-er</b> to a word like - <br>laut ⇉ laut<b>er</b>.<br><br>" +
                    "-> Superlatives are formed by adding <b>-sten</b> or <b>-esten</b> with  <b>am</b> before the word like  -<br>laut ⇉ <b>am</b> laut<b>esten</b><br><br>" +
                    "-> Sometimes an umlaut must be added like -<br> <b>groß</b> (big) ⇉ <b>größer</b> (bigger) ⇉ <b>am größten</b> (the biggest).<br><br>" +
                    "-> <b>Als</b> (as) can be used to make a comparative sentence (similar to than in English)<br> ich bin älter als er. (I am older than him)<br><br>" +
                    "-> <b>Am</b> or an <b>article</b> can be used when making a superlative sentence.<br> Meine Prüfung war <b>die</b> einfach<b>ste</b>. (Mine was the easiest exam.)<br>" +
                    "Meine Flashce ist <b>am</b> voll<b>sten</b>.(My bottle is the fullest.)<br><br>" +
                    "-> Common irregular compararives and superlatives - ";
            word = new String[]{"Viel (a lot)","Gut (good)","Gern (like)","Hoch (high)","Nah (near)"};
            comp = new String[]{"Mehr (more)","Besser (better)","Lieber (prefer)","Höher (higher)","Näher (nearer)"};
            sup = new String[]{"Am meisten (most)","Am besten (best)","Am liebsten (favourite)","Am höchsten (highest)","Am nächsten (nearest)"};
            addHeaders();
            addData();
        }
        txt.setText(Html.fromHtml(sourceString));
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
        tr.addView(getTextView(0, "Word", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "Comparative", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "Superlative", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tl.addView(tr, getTblLayoutParams());
    }

    /**
     * This function add the data to the table
     **/
    public void addData() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < word.length; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, word[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, comp[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 3, sup[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }

}