package com.pedometer.gmachine.myfitnessapp.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.pedometer.gmachine.myfitnessapp.ui.fragment.CurrentProgressFragment;
import com.pedometer.gmachine.myfitnessapp.ui.fragment.HistoryFragment;
import com.pedometer.gmachine.myfitnessapp.R;
import com.pedometer.gmachine.myfitnessapp.ui.adapter.SectionsPageAdapter;



public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;


    boolean running = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);





    }


    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CurrentProgressFragment(), "Current Progress");
        //TODO add history fragment when it will works
        viewPager.setAdapter(adapter);
    }



}
