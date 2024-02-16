package com.example.musicapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.musicapp.Adapter.AllAlbumAdapter;
import com.example.musicapp.Adapter.DanhsachalltheloaiAdapter;
import com.example.musicapp.Model.Album;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaalbumActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Album.Data> albums = new ArrayList<>();

    AllAlbumAdapter allAlbumAdapter;



    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcaalbum);
        init();
        GetData();
    }

    private void GetData() {
        DataService dataService = APIRetrofitClient.getApiService();
        Call<Album> call = dataService.getAllAlbum();
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Album album = response.body();

                if (album != null && album.getData() != null) {
                    albums = (ArrayList<Album.Data>) album.getData();
                    allAlbumAdapter = new AllAlbumAdapter(DanhsachtatcaalbumActivity.this,albums);
                    recyclerView.setLayoutManager(new GridLayoutManager(DanhsachtatcaalbumActivity.this,2));
                    recyclerView.setAdapter(allAlbumAdapter);
                }
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

            }
        });
    }

    private void init(){
        recyclerView = findViewById(R.id.recyclerviewalbum);
        toolbar = findViewById(R.id.toolbaralbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ALBUM");
        toolbar.setTitleTextColor(getResources().getColor(R.color.violet));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}