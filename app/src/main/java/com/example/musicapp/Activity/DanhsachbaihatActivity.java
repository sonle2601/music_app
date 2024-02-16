package com.example.musicapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicapp.Adapter.BaihotAdapter;
import com.example.musicapp.Adapter.DanhsachbaihatAdapter;
import com.example.musicapp.Model.Album;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.Model.Banner;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;
import com.example.musicapp.ViewModel.BaihatbannerViewModel;
import com.example.musicapp.ViewModel.BaihotViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FloatingActionButton floatingActionButton,backButton;

//    private ArrayList<Baihatyeuthich.Data> mangbaihat = new ArrayList<>();

    TextView txttenbai;
    Banner.Data banner;

    ImageButton imgplayds;

    BXH.Data bxh;

    Album.Data album;

    Theloai.Data theloai;

    ImageView imageView;

    DanhsachbaihatAdapter danhsachbaihatAdapter;

    BaihatbannerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        anhxa();
        recyclerView = findViewById(R.id.recyclerdanhsachbaihat);
        viewModel = new ViewModelProvider(this).get(BaihatbannerViewModel.class);
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);
        DataIntent();
        DataIntentbxh();
        DataIntentheloai();
        DataIntenalbum();
        init();
        evenClick();



        if (banner != null ){
            GetDataBanner(banner.getId());
        }
        if (bxh != null){
            getbaihabxh(bxh.getId());
        }
        if (theloai != null){
            getbaihattheloai(theloai.getIdTheloai());
        }
        if (album != null){
            getbaihaalbum(album.getId());
        }
    }



    private void GetDataBanner(int idbanner) {
        viewModel.getBaihatbanner(idbanner).observe(this, baihat->{
            getViewBaiHat((ArrayList<Baihatyeuthich.Data>) baihat);
        });

    }



    private void getbaihabxh(int idbxh) {
        viewModel.getBaihatbxh(idbxh).observe(this, baihat->{
            getViewBaiHat((ArrayList<Baihatyeuthich.Data>) baihat);
        });

    }

    private void getbaihaalbum(int idalbum) {
        viewModel.getBaihatbxh(idalbum).observe(this, baihat->{
            getViewBaiHat((ArrayList<Baihatyeuthich.Data>) baihat);
        });

    }



    private void anhxa() {
        imgplayds = findViewById(R.id.buttonPlay);
        txttenbai = findViewById(R.id.txtdstenbai);
        imageView = findViewById(R.id.dsimgviewdanhsachcakhuc);
    }
    private void init(){
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        floatingActionButton.setEnabled(false);

    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("banner")){
                banner = (Banner.Data) intent.getSerializableExtra("banner");
               txttenbai.setText(banner.getTenBaiHat());
                Picasso.get().load(banner.getHinhBaiHat()).into(imageView);
            }
        }
    }


    private void DataIntentbxh() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("bxh")){
                bxh = (BXH.Data) intent.getSerializableExtra("bxh");
                txttenbai.setText(bxh.getTen());
                Picasso.get().load(bxh.getHinhanh()).into(imageView);

            }
        }
    }

    private void DataIntentheloai() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("theloai")){
                theloai = (Theloai.Data) intent.getSerializableExtra("theloai");
                txttenbai.setText(theloai.getTen());
                Picasso.get().load(theloai.getHinhanh()).into(imageView);
            }
        }
    }

    private void DataIntenalbum() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("album")){
                album = (Album.Data) intent.getSerializableExtra("album");
                txttenbai.setText(album.getTenAlbum());
                Picasso.get().load(album.getHinhAlbum()).into(imageView);
            }
        }
    }
    private void getbaihattheloai(int idtheloai) {
        viewModel.getBaihattheloai(idtheloai).observe(this, baihat->{
            getViewBaiHat((ArrayList<Baihatyeuthich.Data>) baihat);
        });

    }

    public void getViewBaiHat(ArrayList<Baihatyeuthich.Data> baihat) {
        danhsachbaihatAdapter = new DanhsachbaihatAdapter(baihat);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(danhsachbaihatAdapter);
    }

//    private void evenClick(){
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DanhsachbaihatActivity.this, PlayNhacActivity.class);
//            }
//        });
//    }

    private void evenClick(){
        imgplayds.setEnabled(true);
            imgplayds.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(DanhsachbaihatActivity.this, PlayNhacActivity.class);
                    ArrayList<Baihatyeuthich.Data> mangbaihat = new ArrayList<>();
                    for (int i = 0; i < danhsachbaihatAdapter.getItemCount(); i++) {
                        mangbaihat.add(danhsachbaihatAdapter.getItem(i));
                    }
                    intent1.putExtra("mangbaihat", mangbaihat);
                    startActivity(intent1);
                }
            });
    }
}