package com.example.tvonair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tvonair.adapter.TOAAdapter;
import com.example.tvonair.databinding.ActivityMainBinding;
import com.example.tvonair.model.TOAResponse;
import com.example.tvonair.remote.TOAService;

import org.w3c.dom.NameList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private TOAAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
         activityMainBinding.rvToa.setLayoutManager(linearLayoutManager);

        activityMainBinding.pbTOA.setVisibility(View.VISIBLE);

        getTOA();
    }

    private void getTOA() {
        TOAService.getApi().getListOnAir("678ef42a1b584848591cbd02ac3899c3")
                .enqueue(new Callback<TOAResponse>() {
                    @Override
                    public void onResponse(Call<TOAResponse> call, Response<TOAResponse> response) {
                        if (response.isSuccessful()) {
                            activityMainBinding.pbTOA.setVisibility(View.INVISIBLE);
                            List<TOAResponse.ResultsTrailer> resultsTrailers = response.body().getResults();
                            adapter = new TOAAdapter(resultsTrailers, MainActivity.this);
                            activityMainBinding.rvToa.setAdapter(adapter);


//                            for (TOAResponse.ResultsTrailer resultsTrailer : resultsTrailers){
//                                TOAResponse.ResultsTrailer originalName = resultsTrailer.getOriginalName();
//                                Log.d("nama List ", originalName.getOriginalName());
//                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<TOAResponse> call, Throwable t) {
                        Log.e("Error ", t.getMessage());

                    }
                });
    }
}
