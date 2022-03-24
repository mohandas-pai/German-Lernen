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
            sourceString = "❖ Comparatives in German are made by adding <u><b>-er</b></u> to a word like - <br>laut ⇉ laut<u><b>er</b></u>.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ Superlatives are formed by adding <u><b>-sten</b></u> or <u><b>-esten</b></u> with  <u><b>am</b></u> before the word like  -<br>laut ⇉ <u><b>am</b></u> laut<u><b>esten</b></u><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ Sometimes an umlaut must be added like -<br> <u><b>groß</b></u> (big) ⇉ <u><b>größer</b></u> (bigger) ⇉ <u><b>am größten</b></u> (the biggest).<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ <<u><b>Als</b></u> (as) can be used to make a comparative sentence (similar to than in English)<br> <ul><li>ich bin älter als er. (I am older than him)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ <u><b>Am</b></u> or an <u><b>article</b></u> can be used when making a superlative sentence.<br> <ul><li>Meine Prüfung war <u><b>die</b></u> einfach<u><b>ste</b></u>. (Mine was the easiest exam.)</li><li>" +
                    "Meine Flashce ist <u><b>am</b></u> voll<u><b>sten</b></u>.(My bottle is the fullest.)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ Common irregular compararives and superlatives - ";
            word = new String[]{"Viel (a lot)","Gut (good)","Gern (like)","Hoch (high)","Nah (near)"};
            comp = new String[]{"Mehr (more)","Besser (better)","Lieber (prefer)","Höher (higher)","Näher (nearer)"};
            sup = new String[]{"Am meisten (most)","Am besten (best)","Am liebsten (favourite)","Am höchsten (highest)","Am nächsten (nearest)"};
            addHeaders();
            addData();
        }else if(name.equalsIgnoreCase("'Da' mit Präpositionen")){
            sourceString = "❖ 'Da' combines with prepositions and most of the time it changes their meanings.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>❖ It usually refers to things that have been previously mentioned in a sentence " +
                    "or things that are clearly being talked about from the context.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "Da + auf = Darauf<br> Da + mit = Damit<br> Da + bei = Dabei<br> Da + für = Dafür<br> Da + über = Darüber<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "<ul><li>Hast du dein Handy <u><b>dabei</b></u>? (Do you have your phone <u><b>with</u></b> you?)</li><li>Was willst du <u><b>damit</u></b> machen? (What do you want to do <u><b>with</u></b> it?)</li><li>ich habe nicht <u><b>darüber</u></b> nachgedacht. (I haven’t thought <u><b>about it</u></b>.)</li></ul>";
        }else if(name.equalsIgnoreCase("Präsens")){
            sourceString = "❖The present tense is simply used to describe something happening at the moment, and takes <u><b>regular verb conjugations</b></u>.<br><br>" +
                    "<ul><li>Ich <u><b>lese</b></u> das Buch jetzt. (I'm reading the book now.)</li><li>Jetzt <u><b>trinke</b></u> ich meinen Tee. (Now I'm drinking my tea.)</li></ul>";
        }else if(name.equalsIgnoreCase("Perfekt")){
            sourceString = "❖ Present perfect is used to describe something in the past, and it uses the auxiliary verbs <u><b>Haben</u></b> or <u><b>Sein</u></b> + (verb in infinitive + partizip II).<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ If the verb indicates that there is <u><b>movement</u></b>, like: fahren, gehen, spazieren, laufen, .... then <u><b>Sein</u></b> is used, any other verb takes <u><b>Haben</u></b>.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ If the verb is <u><b>seperable</u></b> then the <u><b>-ge (Partizip)</u></b> comes after the seperable part. Ex: angerufen, aufgestanden, ferngesehen, ....<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "<ul><li>Ich <u><b>bin</u></b> nach Japan <u><b>geflogen</u></b>. (I flew to Japan.)</li><li>Heute <u><b>haben</u></b> wir viel Tee <u><b>getrunken</u></b>. (We drank a lot of tea today.)</li><li>Wir <u><b>sind</u></b> mit unseren Freunden 3km <u><b>gelaufen</u></b>, dann <u><b>haben</u></b> wir <u><b>eingekaufen</u></b>.(We ran 3 km with our friends, then we went shopping.)</li><li>Gestern <u><b>habe</u></b> ich viel <u><b>gearbeitet</u></b>. (I worked a lot yesterday.)</li></ul>" ;
            word = new String[]{"ich","du","er/sie/es","wir","ihr","sie","sie"};
            comp = new String[]{"habe","hast","hat","haben","habt","haben","haben"};
            sup = new String[]{"bin","bist","ist","sind","seid","sind","sind"};
            addHeaders();
            addData();
        }else if(name.equalsIgnoreCase("Plusquamperfekt")){
            sourceString = "❖ Pluperfect or past perfect describes an event that took place before the present perfect. It’s basically Präteritum and Perfekt combined; the auxiliary verbs Haben or Sein are used in their simple past form <u><b>Hatten</u></b> and <u><b>Waren</u></b>.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "<ul><li>Er <u><b>hatte</u></b> gut Fußball <u><b>gespielt</u></b>. (He had played football well.)</li><li>Ich <u><b>war</u></b> in Berlin nur einmal <u><b>gewesen</u></b>. (I had only been in Berlin once.)</li><li>Ich <u><b>hatte</u></b> nichts davon <u><b>gewusst</u></b>. (I knew nothing about it.)</li></ul>" ;
            word = new String[]{"ich","du","er/sie/es","wir","ihr","sie","sie"};
            comp = new String[]{"hatte","hattest","hatte","hatten","hattet","hatten","hatten"};
            sup = new String[]{"war","warst","war","waren","wart","waren","waren"};
            addHeaders();
            addData();
        }else if(name.equalsIgnoreCase("Futur")) {
            sourceString = "❖ Future is used to describe intentions for the future or make assumptions about something that will happen in the future. It uses the auxiliary verb <u><b>Werden + verb in infinitive</u></b>.<br><br>" +
                    "<ul><li>Morgen <u><b>werde</u></b> ich viel <u><b>arbeiten</u></b>. (Tomorrow I’ll work a lot.)</li><li>Nächstes Jahr <u><b>werden</u></b> wir in der Universität <u><b>sein</u></b>. (Next year we’ll be in the university.)</li>" +
                    "<li><u><b>Wirst</u></b> du morgen spazieren <u><b>gehen</u></b>? (Will you go on a walk tomorrow?)</li></ul>";
            word = new String[]{"ich","du","er/sie/es","wir","ihr","sie","sie"};
            comp = new String[]{"werde","wirst","wird","werden","werdet","werden","werden"};
            addHeaders();
            addData2();
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
        if(name.equalsIgnoreCase("Plusquamperfekt")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Hatten", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Waren", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Perfekt")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Haben", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Sein", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Futur")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Werden", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else {
            tr.addView(getTextView(0, "Word", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Comparative", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Superlative", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }
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
    public void addData2() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < word.length; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, word[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, comp[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }

}