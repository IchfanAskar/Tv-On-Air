package com.example.tvonair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

        TOAResponse.ResultsTrailer resultsTrailer = getIntent().getParcelableExtra("tv_inten");

        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        displayDetail(resultsTrailer);
    }

    private void displayDetail(TOAResponse.ResultsTrailer resultsTrailer){
        Glide.with(this)
                .load(Constants.BACKDROP_BASE_URL + resultsTrailer.getBackdropPath())
                .into(activityDetailBinding.idDetailTop.backgroundImage);

        Glide.with(this)
                .load(Constants.POSTER_BASE_URL+ resultsTrailer.getPosterPath())
                .into(activityDetailBinding.idDetailBot.posterImage);

        activityDetailBinding.idDetailBot.dJudul.setText(resultsTrailer.getName());
        activityDetailBinding.idDetailBot.dIdJudul.setText(resultsTrailer.getId());
        activityDetailBinding.idDetailBot.dTanggal.setText(resultsTrailer.getFirstAirDate());
        activityDetailBinding.idDetailBot.dVoteAverage.setText((int) resultsTrailer.getVoteAverage());
        activityDetailBinding.idDetailBot.dPopularity.setText((int) resultsTrailer.getPopularity());
        activityDetailBinding.idDetailBot.dLanguage.setText(resultsTrailer.getOriginalLanguage());
    }
}
