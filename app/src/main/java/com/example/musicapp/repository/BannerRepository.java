package com.example.musicapp.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.Model.Banner;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerRepository{
    private ArrayList<Banner.Data> banners = new ArrayList<>();
    private MutableLiveData<List<Banner.Data>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    public BannerRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Banner.Data>> getMutableLiveData() {

        DataService apiService = APIRetrofitClient.getApiService();
        Call<Banner> call = apiService.getBanner();
        call.enqueue(new Callback<Banner>() {
            @Override
            public void onResponse(Call<Banner> call, Response<Banner> response) {

                Banner banner = response.body();

                if (banner != null && banner.getData() != null) {
                    banners = (ArrayList<Banner.Data>) banner.getData();
                    mutableLiveData.setValue(banners);
                }
            }
            @Override
            public void onFailure(Call<Banner> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());
            }
        });
        return mutableLiveData;

    }


}
