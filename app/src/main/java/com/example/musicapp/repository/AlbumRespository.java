package com.example.musicapp.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.musicapp.Model.Album;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRespository {
    private ArrayList<Album.Data> albums = new ArrayList<>();
    private MutableLiveData<List<Album.Data>> mutableLiveData = new MutableLiveData<>();

    private Application application;

    public AlbumRespository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album.Data>> getMutableLiveData(){
        DataService apiDataService = APIRetrofitClient.getApiService();
        Call<Album> call = apiDataService.getAlbum();
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Album album = response.body();

                if(album != null && album.getData() != null){
                    albums =(ArrayList<Album.Data>) album.getData();
                    mutableLiveData.setValue(albums);

                }
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
        return  mutableLiveData;
    }
}
