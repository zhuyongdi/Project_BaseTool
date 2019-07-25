package com.zhuyongdi.basetool.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;

import com.zhuyongdi.basetool.R;
import com.zhuyongdi.basetool.component.FixedSpeedScroller;

import java.lang.reflect.Field;

/**
 * 图片轮播器
 */
public class ZYDSimpleBanner extends ViewPager {

    private boolean isAutoSlide; //是否自动轮播
    private int autoSlideInterval; //自动轮播时间间隔
    private int autoSlideDuration; //自动轮播单张切换时间
    private Handler slideHandler; //自动轮播的Handler
    private ZYDSimpleBannerAutoSlideRunnable slideRunnable; //自动轮播的Runnable
    private ZYDSimpleBannerOnPageChangeListener onPageChangeListener; //OnPageChangeListener

    public ZYDSimpleBanner(@NonNull Context context) {
        this(context, null);
    }

    public ZYDSimpleBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ZYDSimpleBanner);
        isAutoSlide = a.getBoolean(R.styleable.ZYDSimpleBanner_zyd_simple_banner_is_auto_slide, true);
        autoSlideInterval = a.getInt(R.styleable.ZYDSimpleBanner_zyd_simple_banner_auto_slide_interval, 3000);
        a.recycle();
        slideHandler = new Handler();
        slideRunnable = new ZYDSimpleBannerAutoSlideRunnable();
        onPageChangeListener = new ZYDSimpleBannerOnPageChangeListener();
        init();
    }

    private void init() {
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            FixedSpeedScroller mScroller = new FixedSpeedScroller(getContext(), new AccelerateInterpolator());
            mScroller.setThisDuration(autoSlideDuration);
            field.set(this, mScroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.addOnPageChangeListener(onPageChangeListener);
    }

    private class ZYDSimpleBannerOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class ZYDSimpleBannerAutoSlideRunnable implements Runnable {

        @Override
        public void run() {

        }
    }

}
