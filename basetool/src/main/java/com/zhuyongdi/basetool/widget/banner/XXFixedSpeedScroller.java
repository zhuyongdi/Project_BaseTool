package com.zhuyongdi.basetool.widget.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

public class XXFixedSpeedScroller extends Scroller {

    private int mScrollDuration = 1000; // 滑动速度

    public void setScrollDuration(int duration) {
        this.mScrollDuration = duration;
    }

    public XXFixedSpeedScroller(Context context) {
        super(context);
    }

    public XXFixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public XXFixedSpeedScroller(Context context, Interpolator interpolator,
                                boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mScrollDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mScrollDuration);
    }

    public void initViewPagerScroll(ViewPager viewPager) {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(viewPager, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
