package com.example.tvonair.remote;

import com.example.tvonair.model.ReviewResponse;
import com.example.tvonair.model.TOAResponse;
import com.example.tvonair.model.TrailerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIEndpoint {

    @GET("tv/on_the_air")
    Call<TOAResponse> getListOnAir(
            @Query("api_key") String apiKey
//            @Query("language") String bahasa
//            @Query("page") int halaman
    );

    @GET("tv/{tv_id}/reviews")
    Call<ReviewResponse> getReviewByTvId(
            @Path("tv_id") int tvId,
            @Query("api_key") String apiKey
    );

    @GET("tv/{tv_id}/videos")
    Call<TrailerResponse> getTrailerByTvId(
            @Path("tv_id") int tvId,
            @Query("api_key") String apiKey
    );
}
