package com.example.musicapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.musicapp.Model.Album;
import com.example.musicapp.repository.AlbumRespository;

import java.util.List;

public class AlbumViewModel extends AndroidViewModel {
    private AlbumRespository albumRespository;

    public AlbumViewModel(@NonNull Application application) {
        super(application);
        albumRespository = new AlbumRespository(application);
    }

    public LiveData<List<Album.Data>> getAllalbum(){
        return albumRespository.getMutableLiveData();
    }
}
