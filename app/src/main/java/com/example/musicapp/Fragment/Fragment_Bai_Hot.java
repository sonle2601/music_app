package com.example.musicapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.Adapter.BaihotAdapter;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.R;
import com.example.musicapp.ViewModel.BaihotViewModel;

import java.util.ArrayList;

public class Fragment_Bai_Hot extends Fragment {

    View view;

    BaihotAdapter baihotAdapter;

    BaihotViewModel baihotViewModel;

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bai_hat_like, container,false);
        recyclerView =view.findViewById(R.id.recyclerviewbaihatlike);
        baihotViewModel = new ViewModelProvider(requireActivity()).get(BaihotViewModel.class);

        getData();
        return view;
    }

    private void getData() {
        baihotViewModel.getBaihot().observe(getViewLifecycleOwner(), baihat->{
            getViewBaiHot((ArrayList<Baihatyeuthich.Data>) baihat);
        });
    }

    public void getViewBaiHot(ArrayList<Baihatyeuthich.Data> baihat) {
        baihotAdapter = new BaihotAdapter(getActivity(), baihat);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(baihotAdapter);
    }
}
