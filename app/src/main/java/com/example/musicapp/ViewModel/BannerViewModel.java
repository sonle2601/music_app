package com.example.musicapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.musicapp.Model.Banner;
import com.example.musicapp.repository.BannerRepository;

import java.util.List;

public class BannerViewModel extends AndroidViewModel {

    private BannerRepository bannerRepository;


    public BannerViewModel(@NonNull Application application) {
        super(application);
        bannerRepository = new BannerRepository(application);
    }

    public LiveData<List<Banner.Data>> getAllBanner(){
        return bannerRepository.getMutableLiveData();
    }
}
