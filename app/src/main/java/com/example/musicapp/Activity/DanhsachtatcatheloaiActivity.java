package com.example.musicapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.musicapp.Adapter.DanhsachalltheloaiAdapter;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcatheloaiActivity extends AppCompatActivity {
    private ArrayList<Theloai.Data> theloais = new ArrayList<>();


    RecyclerView recyclerView;

    Toolbar toolbar;

    DanhsachalltheloaiAdapter danhsachalltheloaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcatheloai);
        recyclerView = findViewById(R.id.recyclerviewalltheloai);
        init();
        getData();
    }

    private void getData() {
        DataService dataService = APIRetrofitClient.getApiService();
        Call<Theloai> call = dataService.getAllTheloai();
        call.enqueue(new Callback<Theloai>() {
            @Override
            public void onResponse(Call<Theloai> call, Response<Theloai> response) {
                Theloai theloai = response.body();

                if (theloai != null && theloai.getData() != null) {
                    theloais = (ArrayList<Theloai.Data>) theloai.getData();
                    danhsachalltheloaiAdapter = new DanhsachalltheloaiAdapter(DanhsachtatcatheloaiActivity.this,theloais);
                    recyclerView.setLayoutManager(new GridLayoutManager(DanhsachtatcatheloaiActivity.this,1));
                    recyclerView.setAdapter(danhsachalltheloaiAdapter);
                }
            }

            @Override
            public void onFailure(Call<Theloai> call, Throwable t) {
                Log.d("ListSize", " - > Error    " + t.getMessage());
            }
        });
    }


    private void init(){
        toolbar = findViewById(R.id.toolbartheloai);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("THỂ LOẠI");
        toolbar.setTitleTextColor(getResources().getColor(R.color.violet));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}