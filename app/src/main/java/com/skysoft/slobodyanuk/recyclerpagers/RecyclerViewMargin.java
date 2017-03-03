package com.skysoft.slobodyanuk.recyclerpagers;

import android.graphics.Rect;
import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerViewMargin extends RecyclerView.ItemDecoration {
    private final int columns;
    private int margin;

    public RecyclerViewMargin(@IntRange(from = -50) int margin, @IntRange(from = 0) int columns) {
        this.margin = margin;
        this.columns = columns;

    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildLayoutPosition(view);
        outRect.right = margin;
        outRect.left = margin;
    }
}