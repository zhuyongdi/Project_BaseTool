package com.zhuyongdi.basetool.widget.max_height;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 可以设置最大高度的ListView
 * Created by ZhuYongdi on 2018/9/21.
 */
public class XXMaxHeightGridView extends GridView {

    private int maxHeight;

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public XXMaxHeightGridView(Context context) {
        super(context);
    }

    public XXMaxHeightGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public XXMaxHeightGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (maxHeight > -1) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
