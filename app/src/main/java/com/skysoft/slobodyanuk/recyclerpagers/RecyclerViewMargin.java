package com.skysoft.slobodyanuk.recyclerpagers;

import android.graphics.Rect;
import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerViewMargin extends RecyclerView.ItemDecoration {
    private int margin;

    public RecyclerViewMargin(@IntRange(from = -50) int margin) {
        this.margin = margin;

    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildLayoutPosition(view);
//        outRect.right = margin;
//        outRect.left = margin;

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = margin;
        } else if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            outRect.right = margin;
        }

    }
}