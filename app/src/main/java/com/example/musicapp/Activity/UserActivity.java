package com.example.musicapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.musicapp.Model.Taikhoan;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;

public class UserActivity extends AppCompatActivity {

    Taikhoan.Data taikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("user")){
                taikhoan = (Taikhoan.Data) intent.getSerializableExtra("user");
            }
        }
    }
}