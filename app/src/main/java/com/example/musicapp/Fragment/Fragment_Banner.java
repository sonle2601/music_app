package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.musicapp.Adapter.BannerAdapter;
import com.example.musicapp.Model.Banner;
import com.example.musicapp.R;
import com.example.musicapp.ViewModel.BannerViewModel;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Fragment_Banner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;

    BannerAdapter bannerAdapter;

    BannerViewModel bannerViewModel;

    Handler handler;

    Runnable runnable;

    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        bannerViewModel = new ViewModelProvider(requireActivity()).get(BannerViewModel.class);
        anhxa();
        GetData();



        return view;

    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);

    }

    private void GetData() {
        bannerViewModel.getAllBanner().observe(getViewLifecycleOwner(), banner -> {
                getViewBanner((ArrayList<Banner.Data>) banner);
        });

    }
    private void getViewBanner(ArrayList<Banner.Data> banners){
            bannerAdapter = new BannerAdapter(getActivity(),banners);
            viewPager.setAdapter(bannerAdapter);
            circleIndicator.setViewPager(viewPager);
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                          currentItem = viewPager.getCurrentItem();
                          currentItem++;
                          if(currentItem >= viewPager.getAdapter().getCount()){
                              currentItem = 0;
                          }
                          viewPager.setCurrentItem(currentItem,true);
                          handler.postDelayed(runnable, 4500);
                }
            };
            handler.postDelayed(runnable, 4500);

    }


}
