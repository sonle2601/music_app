package com.example.musicapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.musicapp.Activity.DanhsachbaihatActivity;
import com.example.musicapp.Activity.DanhsachtatcatheloaiActivity;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.Model.Theloai;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Theloai extends Fragment {
    View view;

    HorizontalScrollView horizontalScrollView;

    private ArrayList<Theloai.Data> theloais = new ArrayList<>();



    TextView txtxemthem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontal);
        txtxemthem = view.findViewById(R.id.txtxemthem);
        getData();
        txtxemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcatheloaiActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getData() {
        DataService apiService = APIRetrofitClient.getApiService();
        Call<Theloai> call = apiService.getTheloai();
        call.enqueue(new Callback<Theloai>() {
            @Override
            public void onResponse(Call<Theloai> call, Response<Theloai> response) {
                Theloai theloai = response.body();


                if ( theloai != null && theloai.getData() != null){
                    theloais = (ArrayList<Theloai.Data>) theloai.getData();



                }

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(400,350);
                layout.setMargins(10,20,10,30);
                for ( int i = 0; i < (theloais.size()) ; i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.get().load(theloais.get(i).getHinhanh()).into(imageView);
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    final int position = i;
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getContext(), DanhsachbaihatActivity.class);
                            intent.putExtra("theloai", theloais.get(position));
                            getContext().startActivity(intent);
                        }
                    });

                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<Theloai> call, Throwable t) {
                Log.d("ListSize"," - > Error    "+ t.getMessage());

            }
        });
    }


}
