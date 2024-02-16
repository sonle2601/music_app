package com.example.musicapp.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaihatbannerRespository {
    private ArrayList<Baihatyeuthich.Data> mangbaihat = new ArrayList<>();


    private ArrayList<Baihatyeuthich.Data> baihatArrayList = new ArrayList<>();
    private MutableLiveData<List<Baihatyeuthich.Data>> mutableLiveData = new MutableLiveData<>();

    private Application application;

    public BaihatbannerRespository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Baihatyeuthich.Data>> getMutableLiveData(int idbanner){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<Baihatyeuthich> call = apiDataService.getDanhSachBaiHatTheoQuangCao(idbanner);
        call.enqueue(new Callback<Baihatyeuthich>() {
            @Override
            public void onResponse(Call<Baihatyeuthich> call, Response<Baihatyeuthich> response) {

                Baihatyeuthich baihatyeuthich = response.body();
                mangbaihat = (ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();

                if(baihatyeuthich != null && baihatyeuthich.getData() != null){
                    baihatArrayList =(ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();
                    mutableLiveData.setValue(baihatArrayList);

                }
            }

            @Override
            public void onFailure(Call<Baihatyeuthich> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return  mutableLiveData;
    }


    public MutableLiveData<List<Baihatyeuthich.Data>> getMutableLiveDataBaihatbxh(int idbxh){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<Baihatyeuthich> call = apiDataService.getDanhSachBaiHatTheoBXH(idbxh);
        call.enqueue(new Callback<Baihatyeuthich>() {
            @Override
            public void onResponse(Call<Baihatyeuthich> call, Response<Baihatyeuthich> response) {

                Baihatyeuthich baihatyeuthich = response.body();
                mangbaihat = (ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();

                if(baihatyeuthich != null && baihatyeuthich.getData() != null){
                    baihatArrayList =(ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();
                    mutableLiveData.setValue(baihatArrayList);

                }
            }

            @Override
            public void onFailure(Call<Baihatyeuthich> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return  mutableLiveData;
    }


    public MutableLiveData<List<Baihatyeuthich.Data>> getMutableLiveDataBaihatTheloai(int idtheloai){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<Baihatyeuthich> call = apiDataService.getDanhSachBaiHatTheloai(idtheloai);
        call.enqueue(new Callback<Baihatyeuthich>() {
            @Override
            public void onResponse(Call<Baihatyeuthich> call, Response<Baihatyeuthich> response) {

                Baihatyeuthich baihatyeuthich = response.body();
                mangbaihat = (ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();

                if(baihatyeuthich != null && baihatyeuthich.getData() != null){
                    baihatArrayList =(ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();
                    mutableLiveData.setValue(baihatArrayList);

                }
            }

            @Override
            public void onFailure(Call<Baihatyeuthich> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return  mutableLiveData;
    }

    public MutableLiveData<List<Baihatyeuthich.Data>> getMutableLiveDataBaihatAlbum(int idalbum){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<Baihatyeuthich> call = apiDataService.getDanhSachBaiHatAlbum(idalbum);
        call.enqueue(new Callback<Baihatyeuthich>() {
            @Override
            public void onResponse(Call<Baihatyeuthich> call, Response<Baihatyeuthich> response) {

                Baihatyeuthich baihatyeuthich = response.body();
                mangbaihat = (ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();

                if(baihatyeuthich != null && baihatyeuthich.getData() != null){
                    baihatArrayList =(ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();
                    mutableLiveData.setValue(baihatArrayList);

                }
            }

            @Override
            public void onFailure(Call<Baihatyeuthich> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return  mutableLiveData;
    }
}
