package com.example.tvonair.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tvonair.R;
import com.example.tvonair.databinding.ReviewListBinding;
import com.example.tvonair.model.ReviewResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    private List<ReviewResponse.ResultsTrailer> reviews;
    private Context context;

    public ReviewAdapter(List<ReviewResponse.ResultsTrailer> reviews){
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.review_list, parent, false);

        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        final ReviewResponse.ResultsTrailer review = reviews.get(position);

        holder.reviewListBinding.reviewContex.setText(review.getContent());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        ReviewListBinding reviewListBinding;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewListBinding = DataBindingUtil.bind(itemView);
        }
    }
}
