package com.example.tvonair.remote;

import com.example.tvonair.model.TOAResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIEndpoint {

    @GET("tv/on_the_air")
    Call<TOAResponse> getListOnAir(
            @Query("api_key") String apiKey
//            @Query("language") String bahasa
//            @Query("page") int halaman
    );
}
