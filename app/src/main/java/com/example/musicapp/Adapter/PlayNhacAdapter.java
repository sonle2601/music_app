package com.example.musicapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.PlayNhacActivity;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.R;

import java.util.ArrayList;

public class PlayNhacAdapter extends RecyclerView.Adapter<PlayNhacAdapter.ViewHoder> {

    Context context;
    ArrayList<Baihatyeuthich.Data> arrayList;

    public PlayNhacAdapter(Context context, ArrayList<Baihatyeuthich.Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_play_bai_hat, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Baihatyeuthich.Data baihat = arrayList.get(position);

        holder.txttencasi.setText(baihat.getCasi());
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        holder.txtindex.setText(String.valueOf(position+1));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class ViewHoder extends RecyclerView.ViewHolder{
            TextView txtindex, txttenbaihat, txttencasi;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            txttencasi = itemView.findViewById(R.id.txtplaytencasi);
            txttenbaihat = itemView.findViewById(R.id.txtplaytenbaihat);
            txtindex = itemView.findViewById(R.id.txtplaydanhsachnhac);

        }
    }
}
