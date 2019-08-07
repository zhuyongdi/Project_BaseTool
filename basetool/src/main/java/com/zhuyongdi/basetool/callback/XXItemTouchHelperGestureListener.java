package com.zhuyongdi.basetool.callback;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by ZhuYongdi on 2019/4/22.
 */
public class XXItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

    private XXOnGestureSingleTapUpListener onSingleTapUpListener;
    private XXOnGestureLongPressListener onLongPressListener;
    private XXOnGestureDownListener onDownListener;
    private XXOnGestureScrollListener onScrollListener;
    private XXOnGestureFlingListener onFlingListener;
    private XXOnGestureShowPressListener onShowPressListener;
    private XXOnGestureSingleTapConfirmedListener onSingleTapConfirmedListener;
    private XXOnGestureDoubleTapListener onDoubleTapListener;
    private XXOnGestureContextClickListener onContextClickListener;

    public void setOnSingleTapUpListener(XXOnGestureSingleTapUpListener onSingleTapUpListener) {
        this.onSingleTapUpListener = onSingleTapUpListener;
    }

    public void setOnLongPressListener(XXOnGestureLongPressListener onLongPressListener) {
        this.onLongPressListener = onLongPressListener;
    }

    public void setOnDownListener(XXOnGestureDownListener onDownListener) {
        this.onDownListener = onDownListener;
    }

    public void setOnScrollListener(XXOnGestureScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public void setOnFlingListener(XXOnGestureFlingListener onFlingListener) {
        this.onFlingListener = onFlingListener;
    }

    public void setOnShowPressListener(XXOnGestureShowPressListener onShowPressListener) {
        this.onShowPressListener = onShowPressListener;
    }

    public void setOnSingleTapConfirmedListener(XXOnGestureSingleTapConfirmedListener onSingleTapConfirmedListener) {
        this.onSingleTapConfirmedListener = onSingleTapConfirmedListener;
    }

    public void setOnDoubleTapListener(XXOnGestureDoubleTapListener onDoubleTapListener) {
        this.onDoubleTapListener = onDoubleTapListener;
    }

    public void setOnContextClickListener(XXOnGestureContextClickListener onContextClickListener) {
        this.onContextClickListener = onContextClickListener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        if (onSingleTapUpListener != null) {
            onSingleTapUpListener.onSingleTapUp();
        }
        return super.onSingleTapUp(e);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        if (onLongPressListener != null) {
            onLongPressListener.onLongPress();
        }
        super.onLongPress(e);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (onScrollListener != null) {
            onScrollListener.onScroll();
        }
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (onFlingListener != null) {
            onFlingListener.onFling();
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public void onShowPress(MotionEvent e) {
        if (onShowPressListener != null) {
            onShowPressListener.onShowPress();
        }
        super.onShowPress(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if (onDownListener != null) {
            onDownListener.onDown();
        }
        return super.onDown(e);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if (onDoubleTapListener != null) {
            onDoubleTapListener.onDoubleTap();
        }
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return super.onDoubleTapEvent(e);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        if (onSingleTapConfirmedListener != null) {
            onSingleTapConfirmedListener.onSingleTapConfirmed();
        }
        return super.onSingleTapConfirmed(e);
    }

    @Override
    public boolean onContextClick(MotionEvent e) {
        if (onContextClickListener != null) {
            onContextClickListener.onContextClick();
        }
        return super.onContextClick(e);
    }
}
