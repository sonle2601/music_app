package com.example.musicapp.Adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Model.Album;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    Context context;
    ArrayList<Album.Data> arrayAlbum;

    public AlbumAdapter(Context context, ArrayList<Album.Data> arrayAlbum) {
        this.context = context;
        this.arrayAlbum = arrayAlbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album.Data album = arrayAlbum.get(position);
        holder.txtTencasi.setText(album.getTenCaSiAlbum());
        holder.txtTenalbum.setText(album.getTenAlbum());
        Picasso.get().load(album.getHinhAlbum()).into(holder.imgAlbum);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DanhsachbaihatActivity.class);
                intent.putExtra("album", album);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayAlbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAlbum;
        TextView txtTenalbum, txtTencasi;
        public ViewHolder(View itemView){
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.imgalbum);
            txtTenalbum = itemView.findViewById(R.id.txtTenalbum);
            txtTencasi = itemView.findViewById(R.id.txttencasialbum);
        }
    }
}
