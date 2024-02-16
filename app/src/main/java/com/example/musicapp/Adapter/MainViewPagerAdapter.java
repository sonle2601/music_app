package com.example.musicapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.musicapp.Fragment.AccountFragment;
import com.example.musicapp.Fragment.HomeFragment;
import com.example.musicapp.Fragment.LibraryFragment;
import com.example.musicapp.Fragment.SearchFragment;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new SearchFragment();
        } else if (position == 2) {
            return new AccountFragment();
//        } else if (position == 3) {
//            return new AccountFragment();
        } else {
            return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
       return  3;
    }
}
