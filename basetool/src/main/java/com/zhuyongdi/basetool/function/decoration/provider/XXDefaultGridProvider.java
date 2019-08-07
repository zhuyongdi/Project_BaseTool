package com.zhuyongdi.basetool.function.decoration.provider;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

import com.zhuyongdi.basetool.function.decoration.divider.XXColorDivider;
import com.zhuyongdi.basetool.function.decoration.divider.XXIDivider;

/**
 * Created by dkzwm on 2017/4/11.
 *
 * @author dkzwm
 */
public final class XXDefaultGridProvider implements XXIGridProvider {
    private SparseArray<XXIDivider> mRowDividers;
    private SparseArray<XXIDivider> mColumnDividers;
    private SparseBooleanArray mRowNeedDrawFlags;
    private SparseBooleanArray mColumnNeedDrawFlags;
    private XXIDivider mDefaultDivider = new XXColorDivider();
    private XXIDivider mAllRowDivider;
    private XXIDivider mAllColumnDivider;
    private XXIGridProvider mProvider;

    public XXDefaultGridProvider() {
    }

    public XXDefaultGridProvider(@NonNull XXIGridProvider provider) {
        mProvider = provider;
    }

    public void setAllRowDivider(@NonNull XXIDivider allRowDivider) {
        mAllRowDivider = allRowDivider;
    }

    public void setAllColumnDivider(@NonNull XXIDivider allColumnDivider) {
        mAllColumnDivider = allColumnDivider;
    }

    public void setRowDivider(int row, @NonNull XXIDivider divider) {
        if (mRowDividers == null)
            mRowDividers = new SparseArray<>();
        mRowDividers.put(row, divider);
    }

    @Override
    public XXIDivider createRowDivider(int row) {
        final XXIDivider rowDivider = mRowDividers == null ? null : mRowDividers.get(row);
        return rowDivider == null ? mAllRowDivider == null ? mProvider == null ?
                mDefaultDivider : mProvider.createRowDivider(row) : mAllRowDivider : rowDivider;
    }

    public void setColumnDivider(int row, XXIDivider divider) {
        if (mColumnDividers == null)
            mColumnDividers = new SparseArray<>();
        mColumnDividers.put(row, divider);
    }

    @Override
    public XXIDivider createColumnDivider(int column) {
        final XXIDivider columnDivider = mColumnDividers == null ? null : mColumnDividers.get(column);
        return columnDivider == null ? mAllColumnDivider == null ? mProvider == null ?
                mDefaultDivider : mProvider.createColumnDivider(column) : mAllColumnDivider :
                columnDivider;
    }

    public void setRowNeedDraw(int row, boolean need) {
        if (mRowNeedDrawFlags == null)
            mRowNeedDrawFlags = new SparseBooleanArray();
        mRowNeedDrawFlags.put(row, need);
    }

    @Override
    public boolean isRowNeedDraw(int row) {
        return mRowNeedDrawFlags == null ? mProvider == null || mProvider.isRowNeedDraw(row) :
                mRowNeedDrawFlags.get(row, true);
    }

    public void setColumnNeedDraw(int column, boolean need) {
        if (mColumnNeedDrawFlags == null)
            mColumnNeedDrawFlags = new SparseBooleanArray();
        mColumnNeedDrawFlags.put(column, need);
    }

    @Override
    public boolean isColumnNeedDraw(int column) {
        return mColumnNeedDrawFlags == null ? mProvider == null || mProvider.isColumnNeedDraw(column) :
                mColumnNeedDrawFlags.get(column, true);
    }

    @Override
    public void release() {
        if (mRowDividers != null)
            mRowDividers.clear();
        if (mColumnDividers != null)
            mColumnDividers.clear();
        if (mRowNeedDrawFlags != null)
            mRowNeedDrawFlags.clear();
        if (mColumnNeedDrawFlags != null)
            mColumnNeedDrawFlags.clear();
        mProvider = null;
        mAllColumnDivider = null;
        mAllRowDivider = null;
    }
}
