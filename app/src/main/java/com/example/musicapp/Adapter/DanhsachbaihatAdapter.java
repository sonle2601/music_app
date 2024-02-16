package com.example.musicapp.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.PlayNhacActivity;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder> {
    ArrayList<Baihatyeuthich.Data> baihatyeuthichArrayList;

    public DanhsachbaihatAdapter(ArrayList<Baihatyeuthich.Data> baihatyeuthichArrayList) {
        this.baihatyeuthichArrayList = baihatyeuthichArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_danh_sach_bai_hat, parent, false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihatyeuthich.Data baihat = baihatyeuthichArrayList.get(position);
        holder.txtTencasi.setText(baihat.getCasi());
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        Picasso.get().load(baihat.getHinhbaihat()).into(holder.imghinh);
        holder.imgluothich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.imgluothich.setImageResource(R.drawable.iconloved);
                DataService dataService = APIRetrofitClient.getApiService();
                int id = baihat.getId();
                Call<String> callback = dataService.UpdateLuotThich(1,id);
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String ketqua = response.body();
                        if ( ketqua.equals("Success")){
                            Toast.makeText(view.getContext(), "Đã thích", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(view.getContext(), "Lỗi", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("ListSize"," - > Error    "+ t.getMessage());

                    }
                });
                holder.imgluothich.setEnabled(false);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayNhacActivity.class);
                intent.putExtra("baihat", baihat);
                view.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return baihatyeuthichArrayList.size();
    }

    public Baihatyeuthich.Data getItem(int position) {
        return baihatyeuthichArrayList.get(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinh,imgluothich;
        TextView txttenbaihat, txtTencasi;
        public ViewHolder(View itemView){
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.dsbhtxttenbaihat);
            txtTencasi = itemView.findViewById(R.id.dsbhtxttencasi);
            imghinh = itemView.findViewById(R.id.dsbhimgview);
            imgluothich = itemView.findViewById(R.id.dsbhimgluotthich);

        }
    }
}
