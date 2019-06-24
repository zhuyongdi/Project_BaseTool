package com.zhuyongdi.basetool.function.decoration.provider;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

import com.zhuyongdi.app.decoration.divider.ZYDColorDivider;
import com.zhuyongdi.app.decoration.divider.ZYDIDivider;


/**
 * Created by dkzwm on 2017/4/11.
 *
 * @author dkzwm
 */
public final class ZYDDefaultLinearProvider implements ZYDILinearProvider {
    private ZYDIDivider mDefaultDivider = new ZYDColorDivider();
    private SparseArray<ZYDIDivider> mDividers;
    private SparseIntArray mMarginsOfStart;
    private SparseIntArray mMarginsOfEnd;
    private SparseBooleanArray mNeedDrawFlags;
    private ZYDILinearProvider mProvider;
    private int mAllMarginOfStart = -1;
    private int mAllMarginOfEnd = -1;
    private ZYDIDivider mAllDivider;


    public ZYDDefaultLinearProvider() {
    }

    public ZYDDefaultLinearProvider(@NonNull ZYDILinearProvider provider) {
        mProvider = provider;
    }

    public void setAllDivider(@NonNull ZYDIDivider divider) {
        mAllDivider = divider;
    }

    public void setDivider(int position, @NonNull ZYDIDivider divider) {
        if (mDividers == null)
            mDividers = new SparseArray<>();
        mDividers.put(position, divider);
    }

    @Override
    public ZYDIDivider createDivider(int position) {
        final ZYDIDivider divider = mDividers == null ? null : mDividers.get(position);
        return divider == null ? mAllDivider == null ? mProvider == null ?
                mDefaultDivider : mProvider.createDivider(position) : mAllDivider : divider;
    }

    public void setDividerNeedDraw(int position, boolean need) {
        if (mNeedDrawFlags == null)
            mNeedDrawFlags = new SparseBooleanArray();
        mNeedDrawFlags.put(position, need);
    }

    @Override
    public boolean isDividerNeedDraw(int position) {
        if (mNeedDrawFlags == null) {
            return mProvider == null || mProvider.isDividerNeedDraw(position);
        } else {
            return mNeedDrawFlags.get(position, true);
        }
    }

    public void setMarginStart(int position, int margin) {
        if (mMarginsOfStart == null)
            mMarginsOfStart = new SparseIntArray();
        mMarginsOfStart.put(position, margin);
    }

    public void setAllMarginStart(int margin) {
        mAllMarginOfStart = margin;
    }

    @Override
    public int marginStart(int position) {
        final int margin = mMarginsOfStart == null ? -1 : mMarginsOfStart.get(position, -1);
        return margin == -1 ? mAllMarginOfStart == -1 ? mProvider == null ?
                0 : mProvider.marginStart(position) : mAllMarginOfStart : margin;
    }

    public void setMarginEnd(int position, int margin) {
        if (mMarginsOfEnd == null)
            mMarginsOfEnd = new SparseIntArray();
        mMarginsOfEnd.put(position, margin);
    }

    public void setAllMarginEnd(int margin) {
        mAllMarginOfEnd = margin;
    }

    @Override
    public int marginEnd(int position) {
        final int margin = mMarginsOfEnd == null ? -1 : mMarginsOfEnd.get(position, -1);
        return margin == -1 ? mAllMarginOfEnd == -1 ? mProvider == null ?
                0 : mProvider.marginEnd(position) : mAllMarginOfEnd : margin;
    }

    @Override
    public void release() {
        if (mDividers != null)
            mDividers.clear();
        if (mNeedDrawFlags != null)
            mNeedDrawFlags.clear();
        if (mMarginsOfStart != null)
            mMarginsOfStart.clear();
        if (mMarginsOfEnd != null)
            mMarginsOfEnd.clear();
        mAllDivider = null;
        mProvider = null;
    }
}
