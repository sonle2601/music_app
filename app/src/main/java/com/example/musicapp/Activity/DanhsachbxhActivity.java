package com.example.musicapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.musicapp.Adapter.DanhsachbaihatAdapter;
import com.example.musicapp.Adapter.DanhsachbaihatbxhAdapter;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.R;
import com.example.musicapp.ViewModel.BXHViewModel;
import com.example.musicapp.ViewModel.BaihatbannerViewModel;

import java.util.ArrayList;

public class DanhsachbxhActivity extends AppCompatActivity {
    Toolbar toolbar;

    RecyclerView recyclerView;

    DanhsachbaihatbxhAdapter danhsachbaihatbxhAdapter;

    BXHViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(BXHViewModel.class);
        setContentView(R.layout.activity_danhsachbxh);
        getDataBXH();
        anhxa();
        init();
    }

    private void anhxa() {
        toolbar = findViewById(R.id.dsbxhToolbar);
        recyclerView = findViewById(R.id.dsbxhrecyclerview);
    }

    private void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BẢNG XẾP HẠNG");
        toolbar.setTitleTextColor(getResources().getColor(R.color.violet));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getDataBXH() {
        viewModel.getAlldsBXH().observe(this, bxh->{
            getAllViewBXH((ArrayList<BXH.Data>) bxh);
        });

    }

    public void getAllViewBXH(ArrayList<BXH.Data> bxh) {
        danhsachbaihatbxhAdapter = new DanhsachbaihatbxhAdapter(bxh);
        recyclerView.setLayoutManager( new GridLayoutManager(this,2));
        recyclerView.setAdapter(danhsachbaihatbxhAdapter);
    }
}