package com.skysoft.slobodyanuk.recyclerpagers;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by matviy on 03.11.16.
 */

public class UpdatingRecyclerView extends RecyclerView {

    //SCROLLING VIEW TO CENTER
    private static final int DEFAULT_SCROLL_DURATION = 200;
    private boolean mIsForceCentering;
    private final CenterRunnable mCenterRunnable = new CenterRunnable();
    private int mScrollDuration = DEFAULT_SCROLL_DURATION;
    private OnItemCenteredListener mOnItemCenteredListener;
    private Handler mCenteringHandler = new Handler();

    //APPLY TRANSPARENCY TO NON_CENTER VIEWS
    FadeViewModifier mViewModifier;

    public UpdatingRecyclerView(Context context) {
        super(context);
        init();
    }

    public UpdatingRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UpdatingRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setViewModifier(FadeViewModifier vm) {
        this.mViewModifier = vm;
    }

    private void init() {
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == SCROLL_STATE_IDLE) {
                    //TODO check if already centered
                    if (!mIsForceCentering) {
                        mIsForceCentering = true;
                        mCenterRunnable.setView(findViewAtCenter());
                        mCenteringHandler.post(mCenterRunnable);
                    }
                }

                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mViewModifier != null) {
                    for (int i = 0; i < getChildCount(); ++i) {
                        View v = getChildAt(i);
                        mViewModifier.applyToView(v, recyclerView);
                    }
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        removeCallbacks(mCenterRunnable);
        mIsForceCentering = false;
        return super.onTouchEvent(ev);
    }

    public void smoothScrollToView(View v) {
        if (v != null) {
            final float x = v.getX() + v.getWidth() * 0.5f;
            final float halfWidth = getWidth() * 0.5f;
            final int distance = (int) (x - halfWidth);
            smoothScrollBy(distance, mScrollDuration);
        }
    }

    //ONLY HORIZONTAL
    public View findViewAt(final int x) {
        for (int i = 0; i < getChildCount(); ++i) {
            final View v = getChildAt(i);
            if (x >= v.getLeft() && x <= v.getRight()) {
                return v;
            }
        }

        return null;
    }

    public View findViewAtCenter() {
        return findViewAt(getWidth() / 2);
    }

    public class CenterRunnable implements Runnable {

        private View mView;

        public void setView(View v) {
            mView = v;
        }

        public void run() {
            if (mView != null) {
                smoothScrollToView(mView);
                mIsForceCentering = true;
            }
        }
    }

    public interface OnItemCenteredListener {
        void onItemCentered(View v);
    }

}
