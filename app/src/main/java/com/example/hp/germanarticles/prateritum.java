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

public class prateritum extends AppCompatActivity {
    TextView txtHeading;
    String sein[],haben[],werden[],row[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prateritum);

        txtHeading = (TextView)findViewById(R.id.headingText);

        txtHeading.setText("Präteritum");

        row = new String[]{"ich", "du", "er/sie/es", "wir","ihr","Sie","Sie"};
        setdataBasedOnHeading();
        addHeaders();
        addData();
    }
    private void setdataBasedOnHeading() {
        sein = new String[]{"war", "warst", "war", "waren","wart","waren","waren"};
        haben = new String[]{"hatte", "hattest", "hatte", "hatten","hattet","hatten","hatten"};
        werden = new String[]{"wurde", "wurdest", "wurde", "wurden","wurdet","wurden","wurden"};
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
        tr.addView(getTextView(0, "", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "Sein", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "Haben", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tr.addView(getTextView(0, "Werden", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
        tl.addView(tr, getTblLayoutParams());
    }

    /**
     * This function add the data to the table
     **/
    public void addData() {
        TableLayout tl = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < 7; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(i + 1, row[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getApplicationContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(i + 2, sein[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 3, haben[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i + 4, werden[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tl.addView(tr, getTblLayoutParams());
        }
    }
}