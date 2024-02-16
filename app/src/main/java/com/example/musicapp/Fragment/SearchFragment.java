package com.example.musicapp.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.musicapp.Adapter.SearchAdapter;
import com.example.musicapp.Model.Baihatyeuthich;
import com.example.musicapp.R;
import com.example.musicapp.Service.APIRetrofitClient;
import com.example.musicapp.Service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {
    View view;

    Toolbar toolbar;

    RecyclerView recyclerView;

    TextView txtnodata;

    private ArrayList<Baihatyeuthich.Data> baihatArrayList = new ArrayList<>();

    SearchAdapter searchAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        toolbar = view.findViewById(R.id.toolbarsearch);
        recyclerView = view.findViewById(R.id.recyclerviewsearchbaihat);
        txtnodata = view.findViewById(R.id.txtkhongdata);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Tìm kiếm");
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_bai_hat,menu);
        MenuItem menuItem = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               searchBaihat(query);
                return  true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchBaihat(s);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchBaihat(String query){
        DataService dataService = APIRetrofitClient.getApiService();
        Call<Baihatyeuthich> call = dataService.getSearchBaiHat(query);
        call.enqueue(new Callback<Baihatyeuthich>() {
            @Override
            public void onResponse(Call<Baihatyeuthich> call, Response<Baihatyeuthich> response) {
                Baihatyeuthich baihatyeuthich = response.body();
                if(baihatyeuthich != null && baihatyeuthich.getData() != null){
                    baihatArrayList =(ArrayList<Baihatyeuthich.Data>) baihatyeuthich.getData();
                    if (baihatArrayList.size() > 0){
                        searchAdapter = new SearchAdapter(getActivity(),baihatArrayList);
                        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(linearLayout);
                        recyclerView.setAdapter(searchAdapter);
                        txtnodata.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }else{
                        recyclerView.setVisibility(View.GONE);
                        txtnodata.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onFailure(Call<Baihatyeuthich> call, Throwable t) {

            }
        });
    }
}