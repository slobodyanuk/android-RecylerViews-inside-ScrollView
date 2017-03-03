package com.skysoft.slobodyanuk.recyclerpagers.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skysoft.slobodyanuk.recyclerpagers.R;
import com.skysoft.slobodyanuk.recyclerpagers.models.HorizontalListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by serhii_slobodyanuk on 01.03.17.
 */

public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.ViewHolder> {

    int[] colors = {Color.BLUE, Color.GREEN, Color.RED};

    private List<HorizontalListData> data = new ArrayList<>();

    public HorizontalRecyclerAdapter(List<HorizontalListData> data) {
        this.data = data;
    }

    @Override
    public HorizontalRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalRecyclerAdapter.ViewHolder holder, int position) {
        holder.mItemRoot.setBackgroundColor(colors[position % 3]);
        holder.title.setText(data.get(position).getTitle());
        holder.subtitle.setText(data.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_root)
        LinearLayout mItemRoot;

        @BindView(R.id.item_title)
        TextView title;

        @BindView(R.id.item_subtitle)
        TextView subtitle;

        @BindView(R.id.item_image)
        ImageView image;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
