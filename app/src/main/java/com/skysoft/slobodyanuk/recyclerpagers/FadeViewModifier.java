package com.skysoft.slobodyanuk.recyclerpagers;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Yuriy Mysochenko on 12.06.2014.
 */
public class FadeViewModifier extends ViewModifier {

    private static final String TAG = FadeViewModifier.class.getCanonicalName();
    final float FADE_COEFICIENT = 3f;


    private final float mShrinkAmount = 0.15f;
    private final float mShrinkDistance = 1f;

    @Override
    void applyToView(final View v, final RecyclerView parent) {
//        v.setAlpha(parent.getWidth() * 0.5f / (Math.abs(v.getX() + v.getWidth() * 0.5f - parent.getWidth() * 0.5f) * FADE_COEFICIENT));
//        v.setBackgroundColor(v.getContext().getResources().getColor(R.color.colorAccent));

        float midpoint = parent.getWidth() / 2.f;
        float d0 = 0.f;
        float d1 = mShrinkDistance * midpoint;
        float s0 = 1.f;
        float s1 = 1.f - mShrinkAmount;
        float childMidpoint =
                (v.getLeft() + v.getRight()) / 2;
        float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
        float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
        v.setScaleX(scale);
        v.setScaleY(scale);

        int space = (int) (-1 * scale * 15);
        Log.e(TAG, "applyToView: " + space);

        ViewGroup.MarginLayoutParams params =
                (ViewGroup.MarginLayoutParams)v.getLayoutParams();

            params.leftMargin = space;
            params.rightMargin = space;
            v.setLayoutParams(params);

        if (v.getX() + (v.getWidth() / 2) <= parent.getWidth() / 2){
            ViewCompat.setElevation(v, 10);

        }else {
            ViewCompat.setElevation(v, 0);
//            params.leftMargin = 0;
//            params.rightMargin = 0;
//            v.setLayoutParams(params);
        }
    }

}
