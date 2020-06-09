package com.example.hp.germanarticles;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by hp on 19-04-2020.
 */

public class AdjDecl extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private AdjDecl.SectionsPagerAdapter mSectionsPagerAdapter;
    static TableLayout tl;
    private static AdView mAdviewAd;
    /**
     *
     * The {@link ViewPager} that will host the section contents.
     */

    static String[] row = new String[]{"NOM", "AKK", "DAT", "GEN"};

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adj_decl);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new AdjDecl.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static AdjDecl.PlaceholderFragment newInstance(int sectionNumber) {
            AdjDecl.PlaceholderFragment fragment = new AdjDecl.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_modal_verb, container, false);
            mAdviewAd = (AdView)rootView.findViewById(R.id.adView);
            MobileAds.initialize(this.getContext(), "ca-app-pub-6189499490928275~3401756754");
            loadBannerAd("ca-app-pub-3940256099942544/6300978111");
            tl = (TableLayout) rootView.findViewById(R.id.displayLinear);
            TextView textView = (TextView) rootView.findViewById(R.id.headingText);
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
                textView.setText("bestimmter Artikel");
                fillTable("die");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                textView.setText("unbestimmter Artikel");
                fillTable("ein");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
                textView.setText("ohne Artikel");
                fillTable("none");
            }
            return rootView;
        }


        private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
            final TextView tv = new TextView(getContext().getApplicationContext());
            tv.setId(id);
            tv.setText(title.toUpperCase());
            tv.setTextColor(color);
            tv.setPadding(40, 40, 40, 40);
            tv.setGravity(Gravity.CENTER);
            tv.setTypeface(Typeface.DEFAULT, typeface);
            tv.setBackgroundColor(bgColor);
            tv.setLayoutParams(getLayoutParams());
//            tv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    try {
//                        Intent intent = new Intent();
//                        intent.setAction(Intent.ACTION_SEND);
//                        intent.putExtra(Intent.EXTRA_TEXT, tv.getText());
//                        intent.putExtra("key_text_input", tv.getText());
//                        intent.putExtra("key_text_output", "");
//                        intent.putExtra("key_language_from", "du");
//                        intent.putExtra("key_language_to", "en");
//                        intent.putExtra("key_suggest_translation", "");
//                        intent.putExtra("key_from_floating_window", false);
//                        intent.setComponent(new ComponentName(
//                                "com.google.android.apps.translate",
//                                //Change is here
//                                //"com.google.android.apps.translate.HomeActivity"));
//                                "com.google.android.apps.translate.TranslateActivity"));
//                        startActivity(intent);
//                    } catch (ActivityNotFoundException e) {
//                        // TODO Auto-generated catch block
//                        Toast.makeText(getContext().getApplicationContext(), "Sorry, No Google Translation Installed",
//                                Toast.LENGTH_SHORT).show();
//                    }
//
//                    Log.d("MOH->","pressed : "+tv.getText());
//                }
//            });
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

        public void fillTable(String name) {
            String data[] = new String[0];
            String mas[],fem[],neu[],plr[];
            if(name.equalsIgnoreCase("die")){
                mas = new String[]{"e", "en", "en", "en"};
                fem = new String[]{"e", "e", "en", "en"};
                neu = new String[]{"e", "e", "en", "en"};
                plr = new String[]{"en", "en", "en", "en"};
            }else if(name.equalsIgnoreCase("ein")){
                mas = new String[]{"er", "en", "en", "en"};
                fem = new String[]{"e", "e", "en", "en"};
                neu = new String[]{"es", "es", "en", "en"};
                plr = new String[]{"e", "e", "er", "er"};
            }else {
                mas = new String[]{"er", "en", "em", "en"};
                fem = new String[]{"e", "e", "er", "er"};
                neu = new String[]{"es", "es", "em", "en"};
                plr = new String[]{"e", "e", "en", "er"};
            }

            TableRow tr = new TableRow(getContext().getApplicationContext());
            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(0, "", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "MAS", Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "FEM", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "NEU", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
            tr.addView(getTextView(0, "PLR", Color.WHITE, Typeface.BOLD, ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
            tl.addView(tr, getTblLayoutParams());

            for (int i = 0; i < 4; i++) {
                TableRow tr1 = new TableRow(getContext());
                tr1.setLayoutParams(getLayoutParams());
                tr1.addView(getTextView(i + 1, row[i], Color.WHITE, Typeface.NORMAL,  ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
                tr1.addView(getTextView(i + 2, mas[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(getContext(), R.color.colorAccent)));
                tr1.addView(getTextView(i + 3, fem[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(getContext(), R.color.colorAccent)));
                tr1.addView(getTextView(i + 4, neu[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(getContext(), R.color.colorAccent)));
                tr1.addView(getTextView(i + 5, plr[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(getContext(), R.color.colorAccent)));
                tl.addView(tr1, getTblLayoutParams());
            }


        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return AdjDecl.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "1";
                case 1:
                    return "2";
                case 2:
                    return "3";

            }
            return null;
        }
    }
    public static void loadBannerAd(String s){
        mAdviewAd.loadAd(new AdRequest.Builder().build());
    }
}

