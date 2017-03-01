package com.skysoft.slobodyanuk.recyclerpagers.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skysoft.slobodyanuk.recyclerpagers.R;
import com.skysoft.slobodyanuk.recyclerpagers.models.ListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by serhii_slobodyanuk on 01.03.17.
 */

public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.ViewHolder> {

    private List<ListData> data = new ArrayList<>();

    public VerticalRecyclerAdapter(List<ListData> data) {
        this.data = data;
    }

    @Override
    public VerticalRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.subtitle.setText(data.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_title)
        TextView title;

        @BindView(R.id.item_subtitle)
        TextView subtitle;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
