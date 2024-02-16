package com.example.musicapp.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.Model.BXH;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BXHRespository {
    private ArrayList<BXH.Data> bxhs = new ArrayList<>();
    private MutableLiveData<List<BXH.Data>> mutableLiveData = new MutableLiveData<>();

    private Application application;

    public BXHRespository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<BXH.Data>> getMutableLiveData(){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<BXH> call = apiDataService.getBXH();
        call.enqueue(new Callback<BXH>() {
            @Override
            public void onResponse(Call<BXH> call, Response<BXH> response) {
                BXH bxh = response.body();
                if(bxh != null && bxh.getData() != null){
                    bxhs =(ArrayList<BXH.Data>) bxh.getData();
                    mutableLiveData.setValue(bxhs);
                }
            }

            @Override
            public void onFailure(Call<BXH> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return  mutableLiveData;
    }

    public MutableLiveData<List<BXH.Data>> getAllMutableLiveData(){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<BXH> call = apiDataService.getAllBXH();
        call.enqueue(new Callback<BXH>() {
            @Override
            public void onResponse(Call<BXH> call, Response<BXH> response) {
                BXH bxh = response.body();
                if(bxh != null && bxh.getData() != null){
                    bxhs =(ArrayList<BXH.Data>) bxh.getData();
                    mutableLiveData.setValue(bxhs);
                }
            }

            @Override
            public void onFailure(Call<BXH> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return mutableLiveData;
    }
}
