package com.example.musicapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.musicapp.Model.Album;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.repository.AlbumRespository;
import com.example.musicapp.repository.BaihotRespository;

import java.util.List;

public class BaihotViewModel extends AndroidViewModel {
    private BaihotRespository baihotRespository;

    public BaihotViewModel(@NonNull Application application) {
        super(application);
        baihotRespository = new BaihotRespository(application);
    }

    public LiveData<List<Baihatyeuthich.Data>> getBaihot(){
        return baihotRespository.getMutableLiveData();
    }
}
