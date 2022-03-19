package com.example.hp.germanarticles;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Prepositions extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private Prepositions.SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     *
     * The {@link ViewPager} that will host the section contents.
     */



    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepositions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new Prepositions.SectionsPagerAdapter(getSupportFragmentManager());

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
        public static Prepositions.PlaceholderFragment newInstance(int sectionNumber) {
            Prepositions.PlaceholderFragment fragment = new Prepositions.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            final AlertDialog.Builder builder ;
            builder = new AlertDialog.Builder(getContext(),R.style.MyDialogTheme);
            final View rootView = inflater.inflate(R.layout.fragment_preposition, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.headingText);
            Button btn = (Button) rootView.findViewById(R.id.btn);
            String[] wordArray = new String[]{};
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
                textView.setText("Akkusative");
                wordArray = new String[]{"Durch\t\t(Through)","Ohne\t\t(Without)","Gegen\t\t(Against)","für\t\t(For)","um\t\t(At/Around)","bis\t\t(Until/Till)","Entlang\t\t(Alongside)"};
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getActivity(),"Akkusative",Toast.LENGTH_LONG).show();

                        builder.setMessage("mich,dich,ihn,sie,es,uns,euch,sie,Sie\n\nden,die,das,die\neinen,eine,ein\nkeinen,keine,kein,keine\n" +
                                "\nmeinen,meine,mien,meine\n" +
                                "deinen,deine,dien,deine\n" +
                                "seinen,seine,sien,seine\n" +
                                "ihren,ihre,ihr,ihre\n" +
                                "unseren,unsere,unser,unsere\n" +
                                "euren,eure,euer,eure\n")
                                .setCancelable(true);

                        AlertDialog alert = builder.create();
                        //Setting the title manually
                        alert.setTitle("Akkusative");
                        alert.show();

                    }
                });
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                textView.setText("Dative");
                wordArray = new String[]{"aus\t\t(From)","Außer\t\t(Except)","bei\t\t(At/With/From)","mit\t\t(With)","seit\t\t(Since)","nach\t\t(After/To)","von\t\t(Of/By/From)","zu\t\t(At/To)","ab\t\t(From)","Gegenüber\t\t(Opposite To)"};
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getActivity(),"Dative",Toast.LENGTH_LONG).show();

                        builder.setMessage("mir,dir,ihm,ihr,ihm,uns,euch,ihnen,\nihnen\n\n" +
                                "dem,der,dem,den+n\n" +
                                "einem,einer,einem\n" +
                                "keinem,keiner,keinem,keinen+n\n\n" +
                                "meinem,meiner,meinem,meinen+n\n" +
                                "deinem,deiner,deinem,deinen+n\n" +
                                "seinem,seiner,seinem,seinen+n\n" +
                                "ihrem,ihrer,ihrem,ihren+n\n" +
                                "unserem,unserer,unserem,unseren+n\n" +
                                "eurem,eurer,eurem,euren+n")

                                .setCancelable(true);

                        AlertDialog alert = builder.create();
                        //Setting the title manually
                        alert.setTitle("Dative");
                        alert.show();
                    }
                });
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
                textView.setText("Wechseln");
                wordArray = new String[]{"in\t\t(in)","an\t\t(on(vertical))","auf\t\t(on(horizontal))","unter\t\t(Below)","hinter\t\t(Behind)","neben\t\t(Near To/Next To)","zwischen\t\t(Between)","vor\t\t(In Front Of)","über\t\t(Above/Over)"};
                btn.setVisibility(View.INVISIBLE);
            }

            ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.activity_listview, wordArray);

            ListView listView = (ListView) rootView.findViewById(R.id.mobile_list);
            listView.setAdapter(adapter);


            return rootView;
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
            return Prepositions.PlaceholderFragment.newInstance(position + 1);
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
}
