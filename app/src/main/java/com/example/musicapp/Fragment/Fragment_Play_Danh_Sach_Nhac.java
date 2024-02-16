package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Activity.PlayNhacActivity;
import com.example.musicapp.Adapter.PlayNhacAdapter;
import com.example.musicapp.R;

public class Fragment_Play_Danh_Sach_Nhac extends Fragment {

    PlayNhacAdapter playNhacAdapter;
    View view;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_nhac, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewPlayBaihat);
            playNhacAdapter = new PlayNhacAdapter(getActivity(), PlayNhacActivity.mangbaihat);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(playNhacAdapter);
        return view;
    }
}
