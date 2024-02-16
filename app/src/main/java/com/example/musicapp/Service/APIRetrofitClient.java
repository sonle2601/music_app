package com.example.musicapp.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRetrofitClient {
    private static Retrofit retrofit = null;

    public static DataService getApiService() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()  // Set lenient mode to handle malformed JSON
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://sonlh.000webhostapp.com/Server/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(DataService.class);
    }
}
