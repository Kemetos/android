package com.example.rodolphe.translate_template;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.rodolphe.translate_template.fragment.FirstFragment;
import com.example.rodolphe.translate_template.fragment.SecondFragment;
import com.example.rodolphe.translate_template.fragment.ThirdFragment;

public class MainActivity extends FragmentActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //Set page to HOME
        pager.setCurrentItem(1);

        //Bind bottom navigation
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int position = 0;

                switch (item.getItemId()) {
                    case R.id.action_schedules:
                        position = 1;
                        break;
                    case R.id.action_music:
                        position = 2;
                        break;
                }

                pager.setCurrentItem(position);

                return true;
            }
        });
    }

    //Swwitch to activity Inscription
    /** Called when the user clicks the Send button */
    public void inscription(View view) {
        Intent intent = new Intent(this, Inscription.class);
        startActivity(intent);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return FirstFragment.newInstance("FirstFragment, Instance 1");
                case 1: return SecondFragment.newInstance("SecondFragment, Instance 1");
                case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
                case 3: return ThirdFragment.newInstance("ThirdFragment, Instance 2");
                case 4: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
                default: return ThirdFragment.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}