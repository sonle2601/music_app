package com.example.musicapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.repository.BaihatbannerRespository;

import java.util.List;

public class BaihatbannerViewModel extends AndroidViewModel {
    private BaihatbannerRespository baihatbannerRespository;

    public BaihatbannerViewModel(@NonNull Application application) {
        super(application);
        baihatbannerRespository = new BaihatbannerRespository(application);
    }

    public LiveData<List<Baihatyeuthich.Data>> getBaihatbanner(int idbanner){
        return baihatbannerRespository.getMutableLiveData(idbanner);
    }

    public LiveData<List<Baihatyeuthich.Data>> getBaihatbxh(int idbxh){
        return baihatbannerRespository.getMutableLiveDataBaihatbxh(idbxh);
    }

    public LiveData<List<Baihatyeuthich.Data>> getBaihattheloai(int idtheloai){
        return baihatbannerRespository.getMutableLiveDataBaihatTheloai(idtheloai);
    }
    public LiveData<List<Baihatyeuthich.Data>> getBaihatalbum(int idalbum){
        return baihatbannerRespository.getMutableLiveDataBaihatAlbum(idalbum);
    }

}
