package com.example.musicapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.DanhsachbxhActivity;
import com.example.musicapp.Activity.DanhsachtatcaalbumActivity;
import com.example.musicapp.Adapter.AlbumAdapter;
import com.example.musicapp.Model.Album;
import com.example.musicapp.R;
import com.example.musicapp.ViewModel.AlbumViewModel;

import java.util.ArrayList;

public class Fragment_Album extends Fragment {
    View view;

    RecyclerView recyclerView;
    TextView txtxemthem, txttitle;

    AlbumViewModel albumViewModel;

    AlbumAdapter albumAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container,false);
        albumViewModel = new ViewModelProvider(requireActivity()).get(AlbumViewModel.class);
        txttitle = view.findViewById(R.id.titleAlbum);
        txtxemthem = view.findViewById(R.id.txtxemthemalbum);
        recyclerView = view.findViewById(R.id.viewalbum);
        txtxemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaalbumActivity.class);
                startActivity(intent);
            }
        });

        getData();
        return view;
    }

    private void getData() {
        albumViewModel.getAllalbum().observe(getViewLifecycleOwner(), album->{
            getViewAlbum((ArrayList<Album.Data>) album);
        });
    }

    public void getViewAlbum(ArrayList<Album.Data> album) {
        albumAdapter = new AlbumAdapter(getActivity(), album);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(albumAdapter);
    }

}
