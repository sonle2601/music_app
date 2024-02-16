package com.example.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachalltheloaiAdapter extends RecyclerView.Adapter<DanhsachalltheloaiAdapter.ViewHolder>{

    Context context;
    ArrayList<Theloai.Data> theloaiArrayList;

    public DanhsachalltheloaiAdapter(Context context, ArrayList<Theloai.Data> theloaiArrayList) {
        this.context = context;
        this.theloaiArrayList = theloaiArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cac_the_loai, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Theloai.Data theloai = theloaiArrayList.get(position);
        Picasso.get().load(theloai.getHinhanh()).into(holder.imgalltheloai);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DanhsachbaihatActivity.class);
                intent.putExtra("theloai", theloai);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return theloaiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgalltheloai;
        public ViewHolder(View itemView){
            super(itemView);
            imgalltheloai = itemView.findViewById(R.id.alltheloaiimg);
        }
    }
}
