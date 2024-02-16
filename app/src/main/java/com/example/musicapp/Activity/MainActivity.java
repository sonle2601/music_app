package com.example.musicapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.musicapp.Adapter.MainViewPagerAdapter;
import com.example.musicapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("MyTag", "position " + position);
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.user).setChecked(true);
                        break;
//                    case 3:
//                        mBottomNavigationView.getMenu().findItem(R.id.user).setChecked(true);
//                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("MyTag1", "Value of R.id.s: " + item.getItemId());
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    mViewPager.setCurrentItem(0);
                } else if (itemId == R.id.search) {
                    mViewPager.setCurrentItem(1);
                } else if (itemId == R.id.user) {
                    mViewPager.setCurrentItem(2);
//                } else if (itemId == R.id.user) {
//                    mViewPager.setCurrentItem(3);
                }
                return true;
            }


        });



    }
}