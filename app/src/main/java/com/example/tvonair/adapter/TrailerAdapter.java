package com.example.tvonair.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tvonair.R;
import com.example.tvonair.databinding.TrailerListBinding;
import com.example.tvonair.model.TrailerResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {
    private List<TrailerResponse.ResultsTrailer> trailers;
    private Context context;

    public TrailerAdapter(List<TrailerResponse.ResultsTrailer> trailers){
        this.trailers = trailers;
    }
    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.trailer_list, parent, false);

        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {
        final TrailerResponse.ResultsTrailer trailer = trailers.get(position);

        Glide.with(context)
                .load("https://i1.ytimg.com/vi/"+ trailer.getKey() + "/0.jpg")
                .into(holder.trailerListBinding.trailerVideo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=" + trailer.getKey()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder {
        TrailerListBinding trailerListBinding;
        public TrailerViewHolder(@NonNull View itemView) {
            super(itemView);
            trailerListBinding = DataBindingUtil.bind(itemView);
        }
    }
}
