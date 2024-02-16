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
import com.example.musicapp.Model.Album;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllAlbumAdapter extends RecyclerView.Adapter<AllAlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album.Data> albumArrayList;

    public AllAlbumAdapter(Context context, ArrayList<Album.Data> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_album, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album.Data album = albumArrayList.get(position);

        Picasso.get().load(album.getHinhAlbum()).into(holder.imgalbum);
        holder.txttitle.setText(album.getTenAlbum());
        holder.txttencasi.setText(album.getTenCaSiAlbum());
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
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgalbum;
        TextView txttitle,txttencasi;
        public ViewHolder(View itemView){
            super(itemView);
            imgalbum = itemView.findViewById(R.id.dsalbumimgview);
            txttitle = itemView.findViewById(R.id.dsalbumtitle);
            txttencasi = itemView.findViewById(R.id.dsalbumtencasi);

        }
    }
}
