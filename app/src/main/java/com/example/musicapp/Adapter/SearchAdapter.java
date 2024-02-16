package com.example.musicapp.Adapter;

import android.content.Context;
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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihatyeuthich.Data> arrayList;

    public SearchAdapter(Context context, ArrayList<Baihatyeuthich.Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_search_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Baihatyeuthich.Data baihat = arrayList.get(position);
            holder.txttenbaihat.setText(baihat.getTenbaihat());
            holder.txttencasi.setText(baihat.getCasi());
        Picasso.get().load(baihat.getHinhbaihat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenbaihat,txttencasi;
        ImageView imgbaihat, imgluothich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.txtsearchtenbaihat);
            txttencasi = itemView.findViewById(R.id.txtsearchtencasi);
            imgbaihat = itemView.findViewById(R.id.imgSearch);
            imgluothich = itemView.findViewById(R.id.imgSearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("baihat", arrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluothich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluothich.setImageResource(R.drawable.iconloved);
                    DataService dataService = APIRetrofitClient.getApiService();
                    int id = arrayList.get(getPosition()).getId();
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
                    imgluothich.setEnabled(false);
                }
            });
        }
    }
}
