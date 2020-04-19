package com.example.hp.germanarticles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        txt = (TextView)findViewById(R.id.txt);

        txt.setText("\n->Verbs end with -en\n\n" +
                "-> WH questions - VERB in the SECOND position.\n\n" +
                "-> YES/NO questions - VERB in the FIRST position.\n\n" +
                "-> If stem of verb doesnt change then its regular verb, else it is irregular verb.\n\n" +
                "-> First letter of every NOUN SHOULD be capital.\n\n" +
                "-> Nouns in plural always have article die\n\n" +
                "-> ich bin, du bist, er/sie/es ist, wir sind, ihr sied, sie/Sie sind\n\n" +
                "-> ich habe, du hast, es/sie/es hat, wir haben, ihr habt, sie/Sie haben\n\n" +
                "-> When DATIV follow NDA rule, normally \"NOM VERB DAT AKK\" is the order\n\n" +
                "-> KEIN is used to negate NOUN and NICHT is used to negate VERB\n\n" +
                "-> NICHT is also used when negating noun with article and also with proper noun\n\n" +
                "-> MODAL VERB is always in SECOND position and the AUXILIARY/INFINITIVE verb will be at the last postion WITHOUT conjugation\n\n" +
                "-> WECHSELN with ACTION is AKK and with POSITION is DAT\n\n" +
                "-> Verb showing action gehen(go), fahren(travel), fliegen(fly), rennen(run), laufen(walk), kommen(come)\n\n" +
                "-> For SEPARABLE VERBS if there is no modal verb then separate it and add it to the end, if modal verb is present then place the entire verb at the end\n\n" +
                "-> PARTIZIP ZWEI will have a helping verb followed by \"ge-(stem)-t/en\" for irregular verbs or \"an/am/etc-ge-(stem)-t/en\"for separable verbs\n\n");

    }
}
