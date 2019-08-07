package com.zhuyongdi.basetool.widget.adaptation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class XXAdaptedRecyclerView extends RecyclerView {

    public XXAdaptedRecyclerView(Context context) {
        super(context);
    }

    public XXAdaptedRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XXAdaptedRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }

}
