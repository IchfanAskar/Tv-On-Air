package com.example.tvonair.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tvonair.R;
import com.example.tvonair.databinding.ListToaBinding;
import com.example.tvonair.model.TOAResponse;
import com.example.tvonair.model.TOAResponse.ResultsTrailer;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class TOAAdapter extends RecyclerView.Adapter<TOAAdapter.TOAViewHolder> {
    private List<ResultsTrailer> results;
    private Context context;

    public TOAAdapter(List<ResultsTrailer> results, Context context){
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public TOAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_toa, parent, false);
        return new TOAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TOAViewHolder holder, int position) {
        final TOAResponse.ResultsTrailer resultsTrailer = results.get(position);

        holder.viewDataBinding.setTv(resultsTrailer);

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
