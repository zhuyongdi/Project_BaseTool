package com.zhuyongdi.basetool.component;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class XXFixedSpeedScroller extends Scroller {

    private int duration = 400;

    public XXFixedSpeedScroller(Context context) {
        super(context);
    }

    public XXFixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, duration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, duration);
    }

    public int getThisDuration() {
        return duration;
    }

    public void setThisDuration(int duration) {
        this.duration = duration;
    }

}
