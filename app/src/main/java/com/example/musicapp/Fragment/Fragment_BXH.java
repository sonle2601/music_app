package com.example.musicapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.musicapp.Activity.DanhsachbxhActivity;
import com.example.musicapp.Adapter.BXHAdapter;
import com.example.musicapp.Model.BXH;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;
import com.example.musicapp.ViewModel.BXHViewModel;
import com.example.musicapp.ViewModel.BannerViewModel;

import java.util.ArrayList;

import retrofit2.Call;

public class Fragment_BXH extends Fragment {

    View view;

    ListView listView;
    TextView txttitle,txtmore;

    BXHViewModel bxhViewModel;

    BXHAdapter bxhAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bxh, container,false);
        bxhViewModel = new ViewModelProvider(requireActivity()).get(BXHViewModel.class);

        txttitle = view.findViewById(R.id.txttitle);
        listView = view.findViewById(R.id.listview);
        txtmore = view.findViewById(R.id.txtmore);
        getData();
        txtmore.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), DanhsachbxhActivity.class);
            startActivity(intent);
        });
        return view;
    }

    private void getData() {
        bxhViewModel.getAllBXH().observe(getViewLifecycleOwner(), bxh->{
            getViewBXH((ArrayList<BXH.Data>) bxh);
        });
    }

    private void getViewBXH(ArrayList<BXH.Data> bxhs){
        bxhAdapter = new BXHAdapter(getActivity(), android.R.layout.simple_list_item_1,bxhs);
        listView.setAdapter(bxhAdapter);
        setListViewHeightBasedOnChildren(listView);
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }



}
