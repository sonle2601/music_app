package com.example.musicapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.musicapp.Model.BXH;
import com.example.musicapp.repository.BXHRespository;

import java.util.List;

public class BXHViewModel extends AndroidViewModel {
    private BXHRespository bxhRespository;

    public BXHViewModel(@NonNull Application application) {
        super(application);
        bxhRespository = new BXHRespository(application);
    }

    public LiveData<List<BXH.Data>> getAllBXH(){
        return bxhRespository.getMutableLiveData();
    }

    public LiveData<List<BXH.Data>> getAlldsBXH(){
        return bxhRespository.getAllMutableLiveData();
    }
}
