package com.example.hp.germanarticles;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    TextView txtHeading,txt;
    String name;
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
                    "-> Common irregular compararives and superlatives - <br><br><b>Viel</b>(a lot) ⇉ Mehr(more) ⇉ Am meisten(most)<br><br><b>Gut</b>(good) ⇉ Besser(better) ⇉ Am besten(best)<br><br><b>Gern</b>(like) ⇉ Lieber(prefer) ⇉ Am liebsten(favourite)<br><br>" +
                    "<b>Hoch</b>(high) ⇉ Höher(higher) ⇉ Am höchsten(highest)<br><br><b>Nah</b>(near) ⇉ Näher(nearer) ⇉ Am nächsten(nearest)";
        }
        txt.setText(Html.fromHtml(sourceString));
    }
}