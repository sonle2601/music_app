package com.example.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Model.Banner;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
        Context context;
        ArrayList<Banner.Data> bannerArrayList;


    public BannerAdapter(Context context, ArrayList<Banner.Data> bannerArrayList) {
        this.context = context;
        this.bannerArrayList = bannerArrayList;
    }

    @Override
    public int getCount() {
        return bannerArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner, null);

        ImageView imagebackbanner = view.findViewById(R.id.imageviewbackbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imgviewbanner);
        TextView txttitlebanner = view.findViewById(R.id.titlebanner);
        TextView txtnoidung = view.findViewById(R.id.txtnoidung);

        Picasso.get().load(bannerArrayList.get(position).getHinhAnh()).into(imagebackbanner);
        Picasso.get().load(bannerArrayList.get(position).getHinhBaiHat()).into(imgsongbanner);
        txttitlebanner.setText(bannerArrayList.get(position).getTenBaiHat());
        txtnoidung.setText(bannerArrayList.get(position).getNoiDung());

        view.setOnClickListener(view1 -> {
            Intent intent = new Intent(context, DanhsachbaihatActivity.class);
            intent.putExtra("banner", bannerArrayList.get(position));
            context.startActivity(intent);
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
