package com.example.musicapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachbaihatbxhAdapter extends RecyclerView.Adapter<DanhsachbaihatbxhAdapter.ViewHolder> {
    ArrayList<BXH.Data> arrayList;

    public DanhsachbaihatbxhAdapter(ArrayList<BXH.Data> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_danh_sach_bxh, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BXH.Data bxh = arrayList.get(position);
        holder.txttitle.setText(bxh.getTen());
        Picasso.get().load(bxh.getHinhanh()).into(holder.imganhbxh);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DanhsachbaihatActivity.class);
                // Pass the clicked item data to the intent
                intent.putExtra("bxh", bxh);
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imganhbxh;
        TextView txttitle;
        public ViewHolder(View itemView){
            super(itemView);
            imganhbxh = itemView.findViewById(R.id.dsbxhimgview);
            txttitle = itemView.findViewById(R.id.dsbxhtitle);

        }
    }
}
