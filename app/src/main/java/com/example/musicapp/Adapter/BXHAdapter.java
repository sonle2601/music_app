package com.example.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BXHAdapter extends ArrayAdapter<BXH.Data> {
    public BXHAdapter(@NonNull Context context, int resource, @NonNull List<BXH.Data> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txttenbxh;
        ImageView imgicon,imgback;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_bxh,null);
            viewHolder = new ViewHolder();
            viewHolder.txttenbxh = convertView.findViewById(R.id.txttenbxh);
            viewHolder.imgback = convertView.findViewById(R.id.imgviewbxh);
            viewHolder.imgicon = convertView.findViewById(R.id.imgviewiconbxh);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BXH.Data bxh = getItem(position);
        Picasso.get().load(bxh.getHinhanh()).into(viewHolder.imgback);
        Picasso.get().load(bxh.getIcon()).into(viewHolder.imgicon);
        viewHolder.txttenbxh.setText(bxh.getTen());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DanhsachbaihatActivity.class);
                intent.putExtra("bxh", bxh);
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
