package com.zhuyongdi.basetool.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.zhuyongdi.basetool.callback.XXItemTouchHelperGestureListener;
import com.zhuyongdi.basetool.callback.XXOnGestureDownListener;

/**
 * Created by ZhuYongdi on 2019/4/22.
 */
public class XXGestureCatcherRecyclerView extends RecyclerView {

    private GestureDetectorCompat mGestureDetector;

    public XXGestureCatcherRecyclerView(Context context) {
        super(context);
    }

    public XXGestureCatcherRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XXGestureCatcherRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnGestureDownListener(XXOnGestureDownListener onGestureDownListener) {
        XXItemTouchHelperGestureListener itemTouchHelperGestureListener = new XXItemTouchHelperGestureListener();
        itemTouchHelperGestureListener.setOnDownListener(onGestureDownListener);
        this.mGestureDetector = new GestureDetectorCompat(getContext(), itemTouchHelperGestureListener);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (this.mGestureDetector != null) {
            this.mGestureDetector.onTouchEvent(e);
        }
        return super.onInterceptTouchEvent(e);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (this.mGestureDetector != null) {
            this.mGestureDetector.onTouchEvent(e);
        }
        return super.onTouchEvent(e);
    }

}
