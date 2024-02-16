package com.example.musicapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicapp.Activity.UserActivity;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.Model.Taikhoan;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccountFragment extends Fragment {
    View view;

    EditText edtendangnhap, edmatkhau;
    Button btndangnhap;
    TextView txtdangki,txtquenmatkhau;

    private ArrayList<Taikhoan.Data> taikhoanArrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        anhxa();
        init();
        return view;
    }

    private void anhxa() {
        edtendangnhap = view.findViewById(R.id.edtendangnhap);
        edmatkhau = view.findViewById(R.id.edmatkhau);
        btndangnhap = view.findViewById(R.id.btnDangnhap);
        txtdangki = view.findViewById(R.id.txtdangki);
    }

    private void init(){
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tendangnhap = String.valueOf(edtendangnhap.getText());
                String matkhau = String.valueOf(edmatkhau.getText());

                getData(tendangnhap, matkhau);
            }
        });
    }

    private void getData(String tendangnhap, String matkhau){
        DataService dataService = APIRetrofitClient.getApiService();
        Call<Taikhoan>  call = dataService.checkTaikhoan(tendangnhap, matkhau);
        call.enqueue(new Callback<Taikhoan>() {
            @Override
            public void onResponse(Call<Taikhoan> call, Response<Taikhoan> response) {
                Taikhoan taikhoan = response.body();
                if(taikhoan != null && taikhoan.getData() != null){
                    if (taikhoan.getMessage().equals("Success")){
                        taikhoanArrayList = (ArrayList<Taikhoan.Data>) taikhoan.getData();
                        Intent intent = new Intent(view.getContext(), UserActivity.class);
                        intent.putExtra("user", taikhoanArrayList.get(0));
                        view.getContext().startActivity(intent);

                    }else{
                        Toast.makeText(getContext(), "Tài khoản hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<Taikhoan> call, Throwable t) {

            }
        });
    }
}