package com.example.hp.germanarticles;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ModalVerb extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    static TableLayout tl;
    private static AdView mAdviewAd;
    /**
     *
     * The {@link ViewPager} that will host the section contents.
     */

    static String[] row = new String[]{"ich","du","er/sie/es","wir","ihr","sie","Sie"};
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal_verb);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

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
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
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
                textView.setText("Müssen (Must)");
                fillTable("Müssen");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                textView.setText("Können (Can)");
                fillTable("Können");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
                textView.setText("Dürfen (May/Allow)");
                fillTable("Dürfen");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 4){
                textView.setText("Sollen (Should)");
                fillTable("Sollen");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 5){
                textView.setText("Wollen (Want)");
                fillTable("Wollen");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 6){
                textView.setText("Mögen (Like)");
                fillTable("Mögen");
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 7){
                textView.setText("Möchten (Would like)");
                fillTable("Möchten");
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
            if(name.equalsIgnoreCase("Müssen")){
                data = new String[]{"muss","musst","muss","müssen","müsst","müssen","müssen"};
            }else if(name.equalsIgnoreCase("können")){
                data = new String[]{"kann","kannst","kann","können","könnt","können","können"};
            }else if(name.equalsIgnoreCase("dürfen")){
                data = new String[]{"darf","darfst","darf","dürfen","dürft","dürfen","dürfen"};
            }else if(name.equalsIgnoreCase("sollen")){
                data = new String[]{"soll","sollst","soll","sollen","sollt","sollen","sollen"};
            }else if(name.equalsIgnoreCase("wollen")){
                data = new String[]{"will","willst","will","wollen","wollt","wollen","wollen"};
            }else if(name.equalsIgnoreCase("mögen")){
                data = new String[]{"mag","magst","mag","mögen","mögt","mögen","mögen"};
            }else if(name.equalsIgnoreCase("möchten")){
                data = new String[]{"möchte","möchtest","möchte","möchten","möchtet","möchten","möchten"};
            }

            for (int i = 0; i < 7; i++) {
                Log.d("MOH->","Entered");
                TableRow tr = new TableRow(getContext().getApplicationContext());
                tr.setLayoutParams(getLayoutParams());
                tr.addView(getTextView(i + 1, row[i], Color.WHITE, Typeface.NORMAL,  ContextCompat.getColor(this.getContext(), R.color.colorPrimaryDark)));
                tr.addView(getTextView(i + 2, data[i], Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this.getContext(), R.color.colorAccent)));
                Log.d("MOH->","Came till here");
                tl.addView(tr, getTblLayoutParams());

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
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 7;
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
                case 3:
                    return "4";
                case 4:
                    return "5";
                case 5:
                    return "6";
                case 6:
                    return "7";

            }
            return null;
        }
    }

    public static void loadBannerAd(String s){
        mAdviewAd.loadAd(new AdRequest.Builder().build());
    }

}
