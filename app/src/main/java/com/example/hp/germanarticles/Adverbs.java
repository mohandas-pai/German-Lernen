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

public class Adverbs extends AppCompatActivity {

    TextView txtHeading,txt;
    String name;
    String english[],german[],third[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adverbs);

        txtHeading = (TextView)findViewById(R.id.headingText);
        txt = (TextView)findViewById(R.id.txt);

        Bundle b;
        b = getIntent().getExtras();
        name = b.getString("name");

        txtHeading.setText(name);

        setdataBasedOnHeading();
    }

    private void setdataBasedOnHeading() {
        String sourceString = "";
        if (name.equalsIgnoreCase("Adverbs of Time")) {

            english = new String[]{"Today", "Tomorrow", "Day after Tomorrow", "Yesterday", "Tomorrow Morning", "Soon",
                    "Now", "Earlier", "Later", "First", "Since Then", "Back then", "Ever",
                    "Just", "Nowadays", "Always", "For Years", "Until Now", "Never"};
            german = new String[]{"Heute", "Morgen", "Übermorgen", "Gestern", "Morgen früh", "Bald", "Jetzt",
                    "Früher", "Später", "Zuerst", "Seitdem", "Damals", "Jemals", "Eben",
                    "Heutzutage", "Immer", "Jahrelang", "Bisher", "Nie/Niemals"};

            sourceString = "❖ Adverbs of time are used to answer questions regarding time: <u><b>Wann?</b></u> (when),<u><b>Wie oft?</b></u> (How often), <u><b>Wie lange?</b></u> (How long).<br><br>" +
                    "<ul><li><u><b>Heute</b></u> habe ich viel gearbeitet, also möchte ich <u><b>morgen</b></u> viel Spaß haben. (I worked a lot today so tomorrow I want to have fun.)</li><li><u><b>Heutzutage</b></u> benutzt jeder Handy. (Nowadys everyone uses mobile phones.)</li></ul>";

            addHeaders();
            addData();
        } else if (name.equalsIgnoreCase("Adverbs of Place")) {

            english = new String[]{"Here", "There", "Left", "Right", "Up", "Down",
                    "In Front Of", "Behind", "Everywhere", "Nowhere", "Anywhere"};
            german = new String[]{"Hier", "Dort", "Links", "Rechts", "Oben", "Unten", "Vorne",
                    "Hinten", "Überall", "Nirgends", "Irgendwo"};

            sourceString = "<ul><li>Das Haus meiner Eltern ist <u><b>hier/dort</b></u>. (My parents' house is here/there.)</li><li>Der Park <u><b>hinter</b></u> der Bibliothek ist wunderschön. (The park behind the library is wonderful.)</li></ul>";
            addHeaders();
            addData();
        } else if (name.equalsIgnoreCase("Quantifiers")) {

            english = new String[]{"Very", "Quite, Completely", "Really", "Totally", "Absolutely", "Quite, Fairly",
                    "Especially", "Too, Excessively", "A Litte",};
            german = new String[]{"Sehr", "Ganz", "Echt/Wirklich", "Total", "Absolut", "Ziemlich",
                    "Besonders", "Zu", "Ein bisschen"};

            sourceString = "❖ Quantifiers are words that are used to intensify a meaning<br><br>" +
                    "<ul><li>Meine Katze ist <u><b>ziemlich</b></u> klein. (My cat is quite small.)</li><li>Das wetter war <u><b>zu</b></u> heiß. (The weather was so hot.)</li><li>Dieser Rock ist <u><b>total</b></u> altmodisch. (This skirt is totally old fashioned.)</li></ul>";
            addHeaders();
            addData();
        } else if (name.equalsIgnoreCase("Präpositionen mit Akkustiv")) {
            english = new String[]{"Through", "Without, Against", "For", "At/Around", "Until/Till", "Alongside"};
            german = new String[]{"Durch", "Ohne", "Gegen", "für", "um", "bis", "Entlang"};

            sourceString = "<ul><li>Ich nehme eine Tablette <u><b>gegen</b></u> die Schmerzen. (I'm taking a pill for the pain.) (Literally: I am taking a pill against the pain.)</li><li>John hat ein Geschenk <u><b>für</b></u> seine Mutter gekauft. (John bought a gift for his mother.)</li>" +
                    "<li>Er hat noch <u><b>bis</b></u> sechs Uhr Arbeit. (He still has work until 6 o'clock.)</li><li>Meine Mutter trinkt gern Tee <u><b>ohne</b></u> Milch. (My mother like to drink tea without milk.)</li><li>Wir möchten <u><b>um die Welt reisen. (We want to travel around the world.)</li>" +
                    "<li>Morgen will ich mit dem Fahrrad <u><b>durch</b></u> den Park fahren. (Tomorrow, I want to ride my bike through the park.)</li></ul>";

        } else if (name.equalsIgnoreCase("Präpositionen mit Dativ")) {
            english = new String[]{"From", "Except", "At/With/From", "With", "Since", "After/To",
                    "Of/By/From", "At/To", "From", "Opposite To"};
            german = new String[]{"aus", "Außer", "bei", "mit", "seit", "nach",
                    "von", "Zu", "ab", "Gegenüber"};

            sourceString = "<ul><li>Er macht <u><b>ab</b></u> nächstem Montag einen Kurs. (Starting from next Monday he'll participate in a course.)</li><li>Ihr kommt <u><b>aus</b></u> verschiedenen Ländern. (You (pl.) come from different countries.)</li>" +
                    "<li>Ich arbeite <u><b>bei</b></u> einer kleiner Firma. (I work at a small company.)</li><li>Wir lernen Türkisch <u><b>seit</b></u> 2010. (We've been learning Turkish since 2010.)</li><li><u><b>Außer</b></u> einem Kaffee bestellt er nichts. (He didn't order anything except for coffee.)</li>" +
                    "<li><u><b>Gegenüber</b></u> meinem Haus ist eine Bibliothek. (There is a library across from my house.)</li></ul>";
            addHeaders();
            addData();
        } else if (name.equalsIgnoreCase("Wechseln Präpositionen")) {
            english = new String[]{"in", "on(vertical)", "on(horizontal)", "Below", "Behind", "Near To/Next To",
                    "Between", "In Front Of", "Above/Over",};
            german = new String[]{"in", "an", "auf", "Total", "unter", "hinter",
                    "neben", "zwischen", "vor", "über"};

            sourceString = "❖ There are prepositions that take both dative and accusative.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ These are all prepositions that indicate location. The difference is if it's in accusative then it answers the question <u><b>Wohin?</b></u> (Where to?). If it's in dative then then it answers the question <u><b>Wo?</b></u> (Where?).<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "❖ So, if it's in accusative it indicates movement unlike in dative where there is no movement.<p style=\"text-align:center\">⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯</p>" +
                    "<ul><li>Anna hängt das Bild <u><b>an die Wand</b></u>. (Akk.) (Anna hangs the picture on the wall.)</li><li>Jetzt hängt das Bild <u><b>an der Wand</b></u>. (Dat.) (Now the picture is on the wall.)</li>" +
                    "<li>Meine Katze stellt sich <u><b>über den Tisch</b></u>. (Akk.) (My cat lies down over the table.)</li><li>Jetzt liegt meine Katze <u><b>über dem Tisch</b></u>. (Dat.) (Now my cat is over the table.)</li></ul>";
            addHeaders();
            addData();
        } else if (name.equalsIgnoreCase("Haben")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"habe","hast","hat","haben","habt","haben","haben"};
            third = new String[]{"hatte","hattest","hatte","hatten","hattet","hatten","hatten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gehabt</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Sein")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"bin","bist","ist","sind","seid","sind","sind"};
            third = new String[]{"war","warst","war","waren","wart","waren","waren"};
            sourceString = "❖ Uses <b><u>sein/waren + gewesen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Müssen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"muss","musst","muss","müssen","müsst","müssen","müssen"};
            third = new String[]{"musste","musstest","musste","mussten","musstet","mussten","mussten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gemusst/müssen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Können")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"kann","kannst","kann","können","könnt","können","können"};
            third = new String[]{"konnte","konntest","konnte","konnten","konntet","konnten","konnten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gekonnt/können</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Dürfen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"darf","darfst","darf","dürfen","dürft","dürfen","dürfen"};
            third = new String[]{"durfte","durftest","durfte","durften","durftet","durften","durften"};
            sourceString = "❖ Uses <b><u>haben/hatten + gedurft/dürfen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Sollen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"soll","sollst","soll","sollen","sollt","sollen","sollen"};
            third = new String[]{"sollte","solltest","sollte","sollten","solltet","sollten","sollten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gesollt/sollen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Wollen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"will","willst","will","wollen","wollt","wollen","wollen"};
            third = new String[]{"wollte","wolltest","wollte","wollten","wolltet","wollten","wollten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gewollt/wollen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Mögen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"mag","magst","mag","mögen","mögt","mögen","mögen"};
            third = new String[]{"mochte","mochtest","mochte","mochten","mochtet","mochten","mochten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gemocht/mögen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Möchten")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"möchte","möchtest","möchte","möchten","möchtet","möchten","möchten"};
            addHeaders();
            addData();
        } else if (name.equalsIgnoreCase("Werden")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"werde","wirst","wird","werden","werdet","werden","werden"};
            third = new String[]{"wurde","wurdest","wurde","wurden","wurdet","wurden","wurden"};
            sourceString = "❖ Uses <b><u>sein/waren + geworden</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Sagen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"sage","sagst","sagt","sagen","sagt","sagen","sagen"};
            third = new String[]{"sagte","sagtest","sagte","sagten","sagtet","sagten","sagten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gesagt</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Geben")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"gebe","gibst","gibt","geben","gebt","geben","geben"};
            third = new String[]{"gab","gabst","gab","gaben","gabt","gaben","gaben"};
            sourceString = "❖ Uses <b><u>haben/hatten + gegeben</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Kommen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"komme","kommst","kommt","kommen","kommt","kommen","kommen"};
            third = new String[]{"kam","kamst","kam","kamen","kamt","kamen","kamen"};
            sourceString = "❖ Uses <b><u>sein/waren + gekommen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Machen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"mache","machst","macht","machen","macht","machen","machen"};
            third = new String[]{"machte","machtest","machte","machten","machtet","machten","machten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gemacht</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Gehen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"gehe","gehst","geht","gehen","geht","gehen","gehen"};
            third = new String[]{"ging","gingst","ging","gingen","gingt","gingen","gingen"};
            sourceString = "❖ Uses <b><u>sein/waren + gegangen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Heißen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"heiße","heißt","heißt","heißen","heißt","heißen","heißen"};
            third = new String[]{"hieß","hießest","hieß","hießen","hießt","hießen","hießen"};
            sourceString = "❖ Uses <b><u>haben/hatten + gehießen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Wissen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"weiß","weißt","weiß","wissen","wisst","wissen","wissen"};
            third = new String[]{"wusste","wusstest","wusste","wussten","wusstet","wussten","wussten"};
            sourceString = "❖ Uses <b><u>haben/hatten + gewusst</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Sehen")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"sehe","siehst","sieht","sehen","seht","sehen","sehen"};
            third = new String[]{"sah","sahst","sah","sahen","saht","sahen","sahen"};
            sourceString = "❖ Uses <b><u>haben/hatten + gesehen</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Finden")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"finde","findest","findet","finden","findest","finden","finden"};
            third = new String[]{"fand","fandest","fand","fanden","fandet","fanden","fanden"};
            sourceString = "❖ Uses <b><u>haben/hatten + gefunden</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Bleiben")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"bleibe","bleibst","bleibt","bleiben","bleibt","bleiben","bleiben"};
            third = new String[]{"blieb","bliebst","blieb","blieben","bliebt","blieben","blieben"};
            sourceString = "❖ Uses <b><u>sein/waren + geblieben</u></b> for Perfekt and Plusquamperfekt";
            addHeaders();
            addData2();
        } else if (name.equalsIgnoreCase("Fahren")) {
            english = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
            german = new String[]{"fahre","fährst","fährt","fahren","fahrt","fahren","fahren"};
            third = new String[]{"fuhr","fuhrst","fuhr","fuhren","fuhrt","fuhren","fuhren"};
            sourceString = "❖ Uses <b><u>sein/waren + gefahren</u></b> for Perfekt and Plusquamperfekt";
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
        if((name.equalsIgnoreCase("Adverbs of Time")) || (name.equalsIgnoreCase("Adverbs of Place")) || (name.equalsIgnoreCase("Quantifiers"))){
            tr.addView(getTextView(0, "Adverb", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Meaning", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        } else if ((name.equalsIgnoreCase("Präpositionen mit Akkustiv")) || (name.equalsIgnoreCase("Präpositionen mit Dativ")) || (name.equalsIgnoreCase("Wechseln Präpositionen"))){
            tr.addView(getTextView(0, "Präposition", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Meaning", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        } else if ((name.equalsIgnoreCase("Futur"))){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Werden", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        }else if((name.equalsIgnoreCase("Haben"))|| (name.equalsIgnoreCase("Sein")) || (name.equalsIgnoreCase("Müssen")) || (name.equalsIgnoreCase("Können")) || (name.equalsIgnoreCase("Dürfen")) || (name.equalsIgnoreCase("Sollen")) || (name.equalsIgnoreCase("Wollen")) || (name.equalsIgnoreCase("Mögen")) || (name.equalsIgnoreCase("Möchten")) || (name.equalsIgnoreCase("Werden")) || (name.equalsIgnoreCase("Sagen")) || (name.equalsIgnoreCase("Geben")) || (name.equalsIgnoreCase("Kommen")) || (name.equalsIgnoreCase("Machen")) || (name.equalsIgnoreCase("Gehen")) || (name.equalsIgnoreCase("Heißen")) || (name.equalsIgnoreCase("Wissen")) || (name.equalsIgnoreCase("Sehen")) || (name.equalsIgnoreCase("Finden")) || (name.equalsIgnoreCase("Bleiben")) || (name.equalsIgnoreCase("Fahren"))){
            tr.addView(getTextView(0, "Pronomen", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Present", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "Past", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));

        }else{
            tr.addView(getTextView(0, "German", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "English", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));

        }


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

    public void addData2() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < english.length; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, german[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, english[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 3, third[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }
}
