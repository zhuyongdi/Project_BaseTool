package com.zhuyongdi.basetool.function.decoration.provider;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

import com.zhuyongdi.basetool.function.decoration.divider.ZYDColorDivider;
import com.zhuyongdi.basetool.function.decoration.divider.ZYDIDivider;

/**
 * Created by dkzwm on 2017/4/11.
 *
 * @author dkzwm
 */
public final class ZYDDefaultGridProvider implements ZYDIGridProvider {
    private SparseArray<ZYDIDivider> mRowDividers;
    private SparseArray<ZYDIDivider> mColumnDividers;
    private SparseBooleanArray mRowNeedDrawFlags;
    private SparseBooleanArray mColumnNeedDrawFlags;
    private ZYDIDivider mDefaultDivider = new ZYDColorDivider();
    private ZYDIDivider mAllRowDivider;
    private ZYDIDivider mAllColumnDivider;
    private ZYDIGridProvider mProvider;

    public ZYDDefaultGridProvider() {
    }

    public ZYDDefaultGridProvider(@NonNull ZYDIGridProvider provider) {
        mProvider = provider;
    }

    public void setAllRowDivider(@NonNull ZYDIDivider allRowDivider) {
        mAllRowDivider = allRowDivider;
    }

    public void setAllColumnDivider(@NonNull ZYDIDivider allColumnDivider) {
        mAllColumnDivider = allColumnDivider;
    }

    public void setRowDivider(int row, @NonNull ZYDIDivider divider) {
        if (mRowDividers == null)
            mRowDividers = new SparseArray<>();
        mRowDividers.put(row, divider);
    }

    @Override
    public ZYDIDivider createRowDivider(int row) {
        final ZYDIDivider rowDivider = mRowDividers == null ? null : mRowDividers.get(row);
        return rowDivider == null ? mAllRowDivider == null ? mProvider == null ?
                mDefaultDivider : mProvider.createRowDivider(row) : mAllRowDivider : rowDivider;
    }

    public void setColumnDivider(int row, ZYDIDivider divider) {
        if (mColumnDividers == null)
            mColumnDividers = new SparseArray<>();
        mColumnDividers.put(row, divider);
    }

    @Override
    public ZYDIDivider createColumnDivider(int column) {
        final ZYDIDivider columnDivider = mColumnDividers == null ? null : mColumnDividers.get(column);
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
