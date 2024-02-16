package com.example.musicapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerPlayListNhac extends FragmentPagerAdapter {
    public final ArrayList<Fragment> arrayList = new ArrayList<>();

    public ViewPagerPlayListNhac(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public void AddFragment(Fragment fragment){
        arrayList.add(fragment);
    }
}
