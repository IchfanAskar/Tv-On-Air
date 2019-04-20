package com.example.tvonair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tvonair.adapter.ReviewAdapter;
import com.example.tvonair.adapter.TrailerAdapter;
import com.example.tvonair.common.Constants;
import com.example.tvonair.databinding.ActivityDetailBinding;
import com.example.tvonair.model.ReviewResponse;
import com.example.tvonair.model.TOAResponse;
import com.example.tvonair.model.TrailerResponse;
import com.example.tvonair.remote.TOAService;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TOAResponse.ResultsTrailer resultsTrailers = getIntent().getParcelableExtra("tv_intent");

        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        activityDetailBinding.idDetailBot.pbreview.setVisibility(View.VISIBLE);
        displayDetail(resultsTrailers);

        initRecyclerViewReview();
        displayReview(resultsTrailers.getId());

        initRecyclerViewTrailer();
        displayTrailers(resultsTrailers.getId());
    }

    private void displayDetail(TOAResponse.ResultsTrailer resultsTrailers) {
        Glide.with(this)
                .load(Constants.BACKDROP_BASE_URL + resultsTrailers.getBackdropPath())
                .into(activityDetailBinding.idDetailTop.backgroundImage);

        Glide.with(this)
                .load(Constants.POSTER_BASE_URL + resultsTrailers.getPosterPath())
                .into(activityDetailBinding.idDetailBot.posterImage);

        activityDetailBinding.idDetailBot.dJudul.setText(resultsTrailers.getName());
        activityDetailBinding.idDetailBot.dIdJudul.setText(String.valueOf(resultsTrailers.getId()));
        activityDetailBinding.idDetailBot.dTanggal.setText(resultsTrailers.getFirstAirDate());
        activityDetailBinding.idDetailBot.dVoteAverage.setText(String.valueOf(resultsTrailers.getVoteAverage()));
        activityDetailBinding.idDetailBot.dPopularity.setText(String.valueOf(resultsTrailers.getPopularity()));
        activityDetailBinding.idDetailBot.dLanguage.setText(resultsTrailers.getOriginalLanguage());
    }

    private void initRecyclerViewReview(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(DetailActivity.this,  1);
        activityDetailBinding.idDetailBot.rvReview.setLayoutManager(gridLayoutManager);
    }

    private void displayReview(int tvId){
        TOAService.getApi().getReviewByTvId(tvId, "678ef42a1b584848591cbd02ac3899c3")
                .enqueue(new Callback<ReviewResponse>() {
                    @Override
                    public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                        activityDetailBinding.idDetailBot.pbreview.setVisibility(View.INVISIBLE);
                        List<ReviewResponse.ResultsTrailer> reviews = response.body().getResults();
                        ReviewAdapter reviewAdapter = new ReviewAdapter(reviews);
                        activityDetailBinding.idDetailBot.rvReview.setAdapter(reviewAdapter);
                    }

                    @Override
                    public void onFailure(Call<ReviewResponse> call, Throwable t) {
                        Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void initRecyclerViewTrailer(){
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(DetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
        activityDetailBinding.idDetailBot.rvTrailer.setLayoutManager(layoutManager);
    }

    private void displayTrailers(int tvId){
        TOAService.getApi().getTrailerByTvId(tvId, "678ef42a1b584848591cbd02ac3899c3")
                .enqueue(new Callback<TrailerResponse>() {
                    @Override
                    public void onResponse(Call<TrailerResponse> call, Response<TrailerResponse> response) {
                        List<TrailerResponse.ResultsTrailer> trailers = response.body().getResults();
                        TrailerAdapter trailerAdapter = new TrailerAdapter(trailers);
                        activityDetailBinding.idDetailBot.rvTrailer.setAdapter(trailerAdapter);
                    }

                    @Override
                    public void onFailure(Call<TrailerResponse> call, Throwable t) {
                        Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
