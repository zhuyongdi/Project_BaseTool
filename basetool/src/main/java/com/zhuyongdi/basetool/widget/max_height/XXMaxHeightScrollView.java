package com.zhuyongdi.basetool.widget.max_height;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 可设置最大高度的ScrollView
 * Created by Administrator on 2018/12/18.
 */

public class XXMaxHeightScrollView extends ScrollView {

    private int maxHeight;

    public XXMaxHeightScrollView(Context context) {
        super(context);
    }

    public XXMaxHeightScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XXMaxHeightScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            if (maxHeight > 0) {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
