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
    String word[],comp[],sup[],four[];
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
        }else if(name.equalsIgnoreCase("Futur I")) {
            sourceString = "❖ Future is used to describe intentions for the future or make assumptions about something that will happen in the future. It uses the auxiliary verb <u><b>Werden + verb in infinitive</u></b>.<br><br>" +
                    "<ul><li>Morgen <u><b>werde</u></b> ich viel <u><b>arbeiten</u></b>. (Tomorrow I’ll work a lot.)</li><li>Nächstes Jahr <u><b>werden</u></b> wir in der Universität <u><b>sein</u></b>. (Next year we’ll be in the university.)</li>" +
                    "<li><u><b>Wirst</u></b> du morgen spazieren <u><b>gehen</u></b>? (Will you go on a walk tomorrow?)</li></ul>";
            word = new String[]{"ich","du","er/sie/es","wir","ihr","sie","sie"};
            comp = new String[]{"werde","wirst","wird","werden","werdet","werden","werden"};
            addHeaders();
            addData2();
        }else if(name.equalsIgnoreCase("Präteritum")) {
            sourceString = "❖ Imperfect past tense or simple past, is also used to describe an event that happened in the past but Präteritum is used more in texts, articles, novels, ....<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>"+
                    "<ul><li> Letztes Jahr <u><b>lernte</u></b> ich Deutsch. (Last year I learned German.) </li><li> Wir <u><b>waren</u></b> bei Oma. (We were with grandma.)</li><li>Sie <u><b>hatte</u></b> zu viel Arbeite, deshalb <u><b>arbeitete</u></b> sie bis Mitternacht. (She had too much work, that’s why she worked until midnight.)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>"+
            "❖ Verbs and their conjugation change in Präteritum, most important ones:";
            word = new String[]{"ich","du","er/sie/es","wir","ihr","sie","sie"};
            comp = new String[]{"war", "warst", "war", "waren","wart","waren","waren"};
            sup = new String[]{"hatte", "hattest", "hatte", "hatten","hattet","hatten","hatten"};
            four = new String[]{"wurde", "wurdest", "wurde", "wurden","wurdet","wurden","wurden"};
            addHeaders();
            addData3();
        }else if(name.equalsIgnoreCase("Konjunktiv I")){
            sourceString="❖ Conjunctive I is used in indirect speech like when you want to rephrase something said by someone. Verbs and conjugations change.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "<ul><li>Du sagst, du habest verschlafen und seist deshalb zu spät. (You say that you overslept and that you are therefore too late.)</li><li>John sagt, er habe ihn gefragt. (John said that he asked him.)</li>" +
                    "<li>Sie denkt, sie müsse früh ins bett gehen. (She thought that she should go to bed early.)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "All verbs are conjugated like this:";
            word = new String[]{"ich","du","er/sie/es","wir","ihr","sie","sie"};
            comp = new String[]{"Habe (-e)","Habest (-est)","Habe (-e)","Haben (-en)","Habet (-et)","Haben (-en)","Haben (-en)"};
            addHeaders();
            addData2();
        }else if(name.equalsIgnoreCase("Konjunktiv II")){
            sourceString="❖ Conjunctive 2 is used for things that are not real, be it wishes, advices, or suggestions. It can also be used to ask more politely for something.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "<ul><li>Wir würden gern etwas essen. (We’d like to have something to eat.)</li><li>Sie wäre gern am Strand. (She’d like to be at the beach.)</li>" +
                    "<li>Ich hätte nichts gesagt. (I wish I didn’t say anything.)</li><li>Könnten Sie mir bitte helfen? (Could you please help me?)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "Irregular verbs usually take their form in Präteritum + Umlaut";
            word = new String[]{"Haben","Sein","Werden"};
            comp = new String[]{"Hätten","Wären","Würden"};
            addHeaders();
            addData2();
        }else if(name.equalsIgnoreCase("Konjunktionen")){
            sourceString="❖ Conjunctions are words that connect two sentences (because, although,...), and there are two types subordinating conjunctions (Aber-Und), those affect the word order, and coordinating conjunctions (Bevor-Als), that have no effect on the word order.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ <u><b>Wenn</u></b> is used with an event that is more likely to happen<br> <u><b>Falls</u></b> with the less likely events.<br><br><u><b>Als</u></b> is used to represent a time in the past that will not be repeated and cannot be used for the future like: Als ich ein kind war. (When I was a child.)<br>" +
                    "<u><b>Wenn</u></b> is used with events that either are in the future or a past that can be repeated.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ Coordinating conjunctions<ul><li>Ich möchte ein Spiel spielen, <u><b>aber</u></b> ich habe keine Zeit. (I want to play a game, but I have no time.)</li><li>Ich bin sehr beschäftigt, <u><b>denn</u></b> ich habe viel zu tun. (I’m very busy because I have a lot to do.)</li>" +
                    "<li>Möchtest du ins Kino <u><b>oder</u></b> in den Park gehen? (Do you want to go to the cinema or the park?)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ Subordinating conjunctions send the conjugated verb to the end of the sentence. <ul><li>Ich überlege, <u><b>bis</u></b> nächstes Jahr einen Teilzeitjob zu machen, <u><b>weil</u></b> ich Geld verdienen möchte. (I’m considering doing a part time job until next year, because I want to earn money.)</li><li><u><b>Obwohl</u></b> er sagte, <u><b>dass</u></b> er nicht nach draußen gehen möchte, hat er seine Zeit im Park genossen. (Although he said that he didn't want to go outside, he enjoyed his time in the park.)</li>" +
                    "<li><u><b>Wenn/Falls</u></b> es kühler wird, nehme ich eine Jacke mit. (If it’s cold I’ll take a jacket with me.)</li></ul><p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>";
            word = new String[]{"Aber","Denn","Sondern","Oder","Und","","Bevor","Wenn/Falls","Bis","Dass","Nachdem","Ob","Weil","Obwohl","Als (time)"};
            comp = new String[]{"But","Because","But rather","Or","And","","Before","When, if","Until","That","After","If","Because","Although/even though","When"};
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
            tr.addView(getTextView(0, "Hatten", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Waren", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Perfekt")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Haben", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Sein", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Futur I")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Werden", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        } else if(name.equalsIgnoreCase("Konjunktiv I")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Verb", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Konjunktiv II")){
            tr.addView(getTextView(0, "Infinitiv", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Konjunktiv II", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Konjunktionen")){
            tr.addView(getTextView(0, "Conjunction", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Meaning", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if(name.equalsIgnoreCase("Präteritum")){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Sein", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Haben", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Werden", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else {
            tr.addView(getTextView(0, "Word", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Comparative", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Superlative", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
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
            tr.addView(getTextView(i + 1, word[i], Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, comp[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 3, sup[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }
    public void addData2() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < word.length; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, word[i], Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, comp[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }
    public void addData3() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < word.length; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, word[i], Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, comp[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 3, sup[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 4, four[i], Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }



}