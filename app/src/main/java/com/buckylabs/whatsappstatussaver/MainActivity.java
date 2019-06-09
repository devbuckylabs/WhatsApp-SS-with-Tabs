package com.buckylabs.whatsappstatussaver;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.buckylabs.whatsappstatussaver.ui.main.Fragment1;
import com.buckylabs.whatsappstatussaver.ui.main.Fragment2;
import com.buckylabs.whatsappstatussaver.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    SectionsPagerAdapter sectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
       // viewPager.setAdapter(sectionsPagerAdapter);
        setupViewPager(viewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


        //FloatingActionButton fab = findViewById(R.id.fab);

       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setupViewPager (ViewPager mViewPager){
        sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new Fragment1(), "Images");
        sectionsPagerAdapter.addFragment(new Fragment2(), "Videos");
        mViewPager.setAdapter(sectionsPagerAdapter);
    }

}