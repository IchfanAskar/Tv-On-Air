package com.example.tvonair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.tvonair.common.Constants;
import com.example.tvonair.databinding.ActivityDetailBinding;
import com.example.tvonair.model.TOAResponse;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TOAResponse.ResultsTrailer resultsTrailers = getIntent().getParcelableExtra("tv_intent");

        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        displayDetail(resultsTrailers);
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

//    private void initRecyclerView(){
//        LinearLayoutManager layoutManager =
//                new LinearLayoutManager(DetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        activityDetailBinding.
//    }
}
