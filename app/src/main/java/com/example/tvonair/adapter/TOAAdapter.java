package com.example.tvonair.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tvonair.DetailActivity;
import com.example.tvonair.R;
import com.example.tvonair.common.Constants;
import com.example.tvonair.databinding.ListToaBinding;
import com.example.tvonair.model.TOAResponse;
import com.example.tvonair.model.TOAResponse.ResultsTrailer;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class TOAAdapter extends RecyclerView.Adapter<TOAAdapter.TOAViewHolder> {
//    private static final String IMG_BASE_URL ="https://image.tmdb.org/t/p/w185";
    private List<ResultsTrailer> results;
    private Context context;

    public TOAAdapter(List<ResultsTrailer> results, Context context){
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public TOAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_toa, parent, false);
        return new TOAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TOAViewHolder holder, int position) {
        final TOAResponse.ResultsTrailer resultsTrailer = results.get(position);
//        holder.viewDataBinding.setTv(resultsTrailer);

        holder.viewDataBinding.judulToa.setText(resultsTrailer.getName());
        holder.viewDataBinding.tanggalToa.setText(resultsTrailer.getFirstAirDate());

        Glide.with(context)
                .load(Constants.POSTER_BASE_URL + resultsTrailer.getPosterPath())
                .into(holder.viewDataBinding.imgToa);

        //memindahkan data ke fragmet baru

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("tv_intent", resultsTrailer);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class TOAViewHolder extends RecyclerView.ViewHolder {

        ListToaBinding viewDataBinding;

        public TOAViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }

    }
}
