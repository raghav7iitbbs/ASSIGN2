package com.example.asus.assign2;

/**
 * Created by ASUS on 02-04-2017.
 */
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class tab_act extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    String message =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tab);

        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            switch(position){
                case 0:
                    cat_a tab1=new cat_a();
                    //sending the category either 1 or 2
                    tab1.setCat(Integer.parseInt(message));
                    return tab1;
                case 1:
                    cat_b tab2=new cat_b();
                    //sending the category either 1 or 2
                    tab2.setCat(Integer.parseInt(message));
                    return tab2;
                case 2:
                    cat_c tab3=new cat_c();
                    //sending the category either 1 or 2
                    tab3.setCat(Integer.parseInt(message));
                    return tab3;
                default:
                    return null;
            }
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
                    return "CATEGORY A";
                case 1:
                    return "CATEGORY B";
                case 2:
                    return "CATEGORY C";
            }
            return null;
        }
    }
}