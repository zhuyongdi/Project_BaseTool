package com.zhuyongdi.basetool.function.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhuyongdi.basetool.function.decoration.divider.XXIDivider;
import com.zhuyongdi.basetool.function.decoration.provider.XXDefaultLinearProvider;
import com.zhuyongdi.basetool.function.decoration.provider.XXILinearProvider;

/**
 * Created by dkzwm on 2017/4/13.
 *
 * @author dkzwm
 */
public class XXLinearItemDecoration extends XXBaseItemDecoration<XXILinearProvider> {

    private XXLinearItemDecoration(Builder builder) {
        mDrawInsideEachOfItem = builder.mDrawInsideEachOfItem;
        mDrawOverTop = builder.mDrawOverTop;
        mProvider = builder.mProvider;
    }

    @Override
    void calculateItemOffsets(RecyclerView parent, int position, Rect rect) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new UnsupportedOperationException("LinearItemDecoration can only be used in " +
                    "the RecyclerView which use LinearLayoutManager");
        }
        if (mDrawInsideEachOfItem) {
            rect.set(0, 0, 0, 0);
            return;
        }
        LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
        if (manager.getOrientation() == OrientationHelper.VERTICAL) {
            if (manager.getReverseLayout()) {
                if (mProvider.isDividerNeedDraw(position)) {
                    rect.set(0, mProvider.createDivider(position).getDividerSize(), 0, 0);
                } else {
                    rect.set(0, 0, 0, 0);
                }
            } else {
                if (mProvider.isDividerNeedDraw(position)) {
                    rect.set(0, 0, 0, mProvider.createDivider(position).getDividerSize());
                } else {
                    rect.set(0, 0, 0, 0);
                }
            }
        } else {
            if (manager.getReverseLayout()) {
                if (mProvider.isDividerNeedDraw(position)) {
                    rect.set(mProvider.createDivider(position).getDividerSize(), 0, 0, 0);
                } else {
                    rect.set(0, 0, 0, 0);
                }
            } else {
                if (mProvider.isDividerNeedDraw(position)) {
                    rect.set(0, 0, mProvider.createDivider(position).getDividerSize(), 0);
                } else {
                    rect.set(0, 0, 0, 0);
                }
            }
        }
    }

    @Override
    void drawVerticalOrientationDividers(Canvas c, RecyclerView parent,
                                         RecyclerView.LayoutManager layoutManager) {
        LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
        int childCount = parent.getChildCount();
        float left, top, right, bottom;
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
            int position = lp.getViewAdapterPosition();
            if (position < 0 || !mProvider.isDividerNeedDraw(position))
                continue;
            float transitionX = view.getTranslationX();
            float transitionY = view.getTranslationY();
            left = view.getLeft() - lp.leftMargin + transitionX + mProvider.marginStart(position);
            right = view.getRight() + lp.rightMargin + transitionX - mProvider.marginEnd(position);
            XXIDivider divider = mProvider.createDivider(position);
            if (manager.getReverseLayout()) {
                if (divider.getType() == XXIDivider.TYPE_DRAWABLE) {
                    bottom = view.getTop() - lp.topMargin + transitionY;
                    top = bottom - divider.getDividerSize();
                } else {
                    top = view.getTop() - lp.topMargin - divider.getDividerSize() / 2f + transitionY;
                    bottom = top;
                }
                if (mDrawInsideEachOfItem) {
                    top += divider.getDividerSize();
                    bottom += divider.getDividerSize();
                }
            } else {
                if (divider.getType() == XXIDivider.TYPE_DRAWABLE) {
                    top = view.getBottom() + lp.bottomMargin + transitionY;
                    bottom = top + divider.getDividerSize();
                } else {
                    top = view.getBottom() + lp.bottomMargin + divider.getDividerSize() / 2f + transitionY;
                    bottom = top;
                }
                if (mDrawInsideEachOfItem) {
                    top -= divider.getDividerSize();
                    bottom -= divider.getDividerSize();
                }
            }
            divider.draw(c, left, top, right, bottom);
        }
    }

    @Override
    void drawHorizontalOrientationDividers(Canvas c, RecyclerView parent,
                                           RecyclerView.LayoutManager layoutManager) {
        LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
        int childCount = parent.getChildCount();
        float left, top, right, bottom;
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
            int position = lp.getViewAdapterPosition();
            if (position < 0 || !mProvider.isDividerNeedDraw(position))
                continue;
            float transitionX = view.getTranslationX();
            float transitionY = view.getTranslationY();
            top = view.getTop() - lp.topMargin + transitionY + mProvider.marginStart(position);
            bottom = view.getBottom() + lp.bottomMargin + transitionY - mProvider.marginEnd(position);
            XXIDivider divider = mProvider.createDivider(position);
            if (manager.getReverseLayout()) {
                if (divider.getType() == XXIDivider.TYPE_DRAWABLE) {
                    right = view.getLeft() - lp.leftMargin + transitionX;
                    left = right - divider.getDividerSize();
                } else {
                    left = view.getLeft() - lp.leftMargin - divider.getDividerSize() / 2f + transitionY;
                    right = left;
                }
                if (mDrawInsideEachOfItem) {
                    left += divider.getDividerSize();
                    right += divider.getDividerSize();
                }
            } else {
                if (divider.getType() == XXIDivider.TYPE_DRAWABLE) {
                    left = view.getRight() + lp.rightMargin + transitionX;
                    right = left + divider.getDividerSize();
                } else {
                    left = view.getRight() + lp.rightMargin + divider.getDividerSize() / 2f + transitionX;
                    right = left;
                }
                if (mDrawInsideEachOfItem) {
                    left -= divider.getDividerSize();
                    right -= divider.getDividerSize();
                }
            }
            divider.draw(c, left, top, right, bottom);
        }
    }


    public static class Builder implements IBuilder<Builder, XXILinearProvider> {
        Context mContext;
        XXILinearProvider mProvider;
        boolean mDrawInsideEachOfItem = false;
        boolean mDrawOverTop = false;

        public Builder(@NonNull Context context) {
            mContext = context;
        }

        @Override
        public Builder drawOverTop(boolean drawOverTop) {
            mDrawOverTop = drawOverTop;
            return this;
        }

        @Override
        public Builder drawInsideEachOfItem(boolean drawInsideEachOfItem) {
            mDrawInsideEachOfItem = drawInsideEachOfItem;
            return this;
        }

        @Override
        public Builder provider(@NonNull XXILinearProvider provider) {
            if (mProvider != null) {
                throw new IllegalArgumentException("You must set up the ILinearProvider before " +
                        "configuring the custom rules");
            }
            mProvider = provider;
            return this;
        }

        public Builder divider(int position, XXIDivider divider) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setDivider(position, divider);
            return this;
        }

        public Builder divider(XXIDivider divider) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setAllDivider(divider);
            return this;
        }

        public Builder needDraw(int position, boolean need) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setDividerNeedDraw(position, need);
            return this;
        }

        public Builder marginStart(int margin) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setAllMarginStart(margin);
            return this;
        }

        public Builder marginStart(int position, int margin) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setMarginStart(position, margin);
            return this;
        }

        public Builder marginEnd(int margin) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setAllMarginEnd(margin);
            return this;
        }

        public Builder marginEnd(int position, int margin) {
            checkProvider();
            ((XXDefaultLinearProvider) mProvider).setMarginEnd(position, margin);
            return this;
        }

        private void checkProvider() {
            checkProviderIsNull();
            if (!(mProvider instanceof XXDefaultLinearProvider))
                mProvider = new XXDefaultLinearProvider(mProvider);
        }

        private void checkProviderIsNull() {
            if (mProvider == null)
                mProvider = new XXDefaultLinearProvider();
        }

        public XXLinearItemDecoration build() {
            checkProviderIsNull();
            return new XXLinearItemDecoration(this);
        }
    }
}
